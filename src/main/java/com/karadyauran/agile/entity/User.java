package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference("projectMemberUserReference")
    private List<ProjectMember> projectMembers;

    @OneToMany(mappedBy = "assignedTo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("taskAssignedToReference")
    private List<Task> assignedTasks;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("taskCreatedTasksReference")
    private List<Task> createdTasks;

    @OneToMany(mappedBy = "commentUser", cascade = CascadeType.ALL)
    @JsonManagedReference("commentUserReference")
    private List<Comment> taskComments;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @JsonManagedReference("notificationSenderReference")
    private List<Notification> sendNotifications;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    @JsonManagedReference("notificationReceiverReference")
    private List<Notification> receiveNotifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference("attachmentUserReference")
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("projectOwnerReference")
    private List<Project> ownedProjects;

    @ManyToMany
    @JoinTable(
            name = "user_project",
            joinColumns = @JoinColumn(name = "up_user_id"),
            inverseJoinColumns = @JoinColumn(name = "up_project_id")
    )
    private List<Project> projects;

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
        return String.format("User: %s, %s, %s", userId, username, createdAt);
    }
}
