package com.karadyauran.agile.entity;

import com.karadyauran.agile.entity.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
  @Id
  private UUID taskId;
  private String title;
  private String description;
  private TaskStatus status;
  private LocalDate createdAt;
  private Date dueDate;

  private UUID projectId;
  private UUID assignedToId;

  @ManyToOne(targetEntity = Project.class)
  private Project project;
  @OneToOne(targetEntity = User.class)
  private User assignedTo;
  @OneToMany(mappedBy = "task", targetEntity = Comment.class)
  private List<Comment> taskComments;
  @OneToMany(mappedBy = "task", targetEntity = Attachment.class)
  private List<Attachment> attachments;
  @OneToMany(mappedBy = "task", targetEntity = TimeLog.class)
  private List<TimeLog> timeLogs;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Task task)) return false;
    return Objects.equals(taskId, task.taskId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId);
  }

  @Override
  public String toString() {
    return String.format("Task: %s, %s",
            title, status);
  }
}
