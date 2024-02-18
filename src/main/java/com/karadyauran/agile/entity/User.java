package com.karadyauran.agile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;


@Data
@Entity
@Table(name = "users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements UserDetails
{
    @Id
    @UuidGenerator
    @Column(name = "id")
    UUID id;

    @Column(name = "username")
    String username;

    @Column(name = "firstname")
    String firstname;

    @Column(name = "surname")
    String surname;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @CreationTimestamp
    @Column(name = "registered_at", updatable = false)
    Timestamp registeredAt;

    @ManyToMany
    @JoinTable(
            name = "user_projects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    List<Project> projects;

    @OneToMany(mappedBy = "user")
    List<Role> roles;

    @OneToMany(mappedBy = "assignedToUser")
    List<Task> tasks;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    @OneToMany(mappedBy = "senderUser")
    List<Notification> sent;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, username);
    }

    @Override
    public String toString()
    {
        return String.format(
                "username: %s\nfirstname: %s\nsurname: %s\n",
                this.username,
                this.firstname,
                this.surname
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> (GrantedAuthority) role)
                .collect(Collectors.toList());
    }


    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
