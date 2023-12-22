package com.karadyauran.agile.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "u_user_id")
    private UUID userId;

    @Column(name = "u_user_name")
    private String username;

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_password_hash")
    private String passwordHash;

    @Column(name = "u_created_at")
    private LocalDate createdAt;

    @Column(name = "u_last_login")
    private LocalDate lastLogin;

    @OneToMany(mappedBy = "sender")
    private List<Notification> sentNotifications;

    @OneToMany(mappedBy = "user")
    private List<ProjectMember> listOfAssignedProjects;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "assignedTo")
    private List<Task> tasks;

    @OneToMany(mappedBy = "user")
    private List<TimeLog> timeLogs;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userId);
    }

    @Override
    public String toString()
    {
        return String.format("User: %s, %s, %s, %s",
                userId, username, createdAt, tasks);
    }
}
