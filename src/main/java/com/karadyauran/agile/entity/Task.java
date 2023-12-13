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
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
  @Id
  @Column(name = "task_id")
  private UUID taskId;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "status")
  private TaskStatus status;

  @Column(name = "created_at")
  private LocalDate createdAt;

  @Column(name = "due_date")
  private Date dueDate;

  @Column(name = "project_id")
  private UUID projectId;

  @Column(name = "assigned_to_id")
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
