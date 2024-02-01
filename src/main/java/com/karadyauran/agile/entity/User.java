package com.karadyauran.agile.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Data
@Entity
@Table(name = "users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User
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

    @ManyToMany(mappedBy = "users")
    List<Role> roles;

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
}
