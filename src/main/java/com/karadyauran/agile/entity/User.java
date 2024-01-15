package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "u_user_id")
    private UUID userId;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_surname")
    private String surname;

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_password_hash")
    private String passwordHash;

    @Column(name = "u_created_at")
    private LocalDate createdAt;

    @OneToMany(mappedBy = "user")
    List<ProjectMember> projectMembers;

    @OneToMany(mappedBy = "assignedTo")
    @JsonManagedReference("taskAssignedToReference")
    private List<Task> assignedTasks;

    @OneToMany(mappedBy = "createdBy")
    private List<Task> createdTasks;

    @OneToMany(mappedBy = "commentUser")
    private List<Comment> taskComments;

    @OneToMany(mappedBy = "sender")
    private List<Notification> sendNotifications;

    @OneToMany(mappedBy = "receiver")
    private List<Notification> receiveNotifications;

    @OneToMany(mappedBy = "user")
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "owner")
    private List<Project> ownedProjects;

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
        return String.format("User: %s, %s, %s",
                userId, username, createdAt);
    }
}
