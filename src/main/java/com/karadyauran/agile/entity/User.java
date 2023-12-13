package com.karadyauran.agile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table("users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @Column("user_id")
  private UUID userId;

  @Column("user_name")
  private String username;

  @Column("email")
  private String email;

  @Column("password_hash")
  private String passwordHash;

  @Column("created_at")
  private LocalDate createdAt;

  @Column("last_login")
  private LocalDate lastLogin;

  @OneToMany(mappedBy = "user", targetEntity = Notification.class)
  private List<Notification> notifications;

  @OneToMany(mappedBy = "user", targetEntity = ProjectMember.class)
  private List<ProjectMember> listOfAssignedProjects;

  @OneToMany(mappedBy = "user", targetEntity = Comment.class)
  private List<Comment> comments;

  @OneToMany(mappedBy = "user", targetEntity = Task.class)
  private List<Task> tasks;

  @OneToMany(mappedBy = "user", targetEntity = Attachment.class)
  private List<TimeLog> timeLogs;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return userId == user.userId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId);
  }

  @Override
  public String toString() {
    return String.format("User: %s, %s, %s, %s",
            userId, username, createdAt, tasks);
  }
}
