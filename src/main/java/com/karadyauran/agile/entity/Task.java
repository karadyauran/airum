package com.karadyauran.agile.entity;

import com.karadyauran.agile.entity.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
  private UUID taskId;
  private String title;
  private String description;
  private TaskStatus status;
  private LocalDate createdAt;
  private Date dueDate;

  private UUID projectId;
  private UUID assignedToId;

  private Project project;
  private User assignedTo;

  private List<Comment> taskComments;
  private List<Attachment> attachments;
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
