package com.karadyauran.agile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
  @Id
  @Column(name = "c_comment_id")
  private UUID commentId;

  @Column(name = "c_task_id")
  private UUID taskId;

  @Column(name = "c_user_id")
  private UUID userId;

  @Column(name = "c_comment")
  private String text;

  @Column(name = "c_created_at")
  private LocalDate createdAt;

  @ManyToOne
  @JoinColumn(name = "c_task_id", insertable = false, updatable = false)
  private Task task;

  @ManyToOne
  @JoinColumn(name = "c_user_id", insertable = false, updatable = false)
  private User user;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Comment comment = (Comment) o;
    return Objects.equals(commentId, comment.commentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commentId);
  }

  @Override
  public String toString() {
    return String.format("Comment: %s, %s",
            taskId, text);
  }
}
