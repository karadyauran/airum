package com.karadyauran.agile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private UUID id;
  private String username;
  private String email;
  private String passwordHash;
  private LocalDate createdAt;
  private LocalDate lastLogin;

  private List<Notification> notifications;
  private List<ProjectMember> listOfAssignedProjects;
  private List<Comment> comments;
  private List<Task> tasks;
  private List<TimeLog> timeLogs;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id == user.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return String.format("User: %s, %s, %s, %s",
            id, username, createdAt, tasks);
  }
}
