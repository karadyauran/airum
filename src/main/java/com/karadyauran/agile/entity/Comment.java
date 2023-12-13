package com.karadyauran.agile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
  @Column(name = "comment_id")
  private UUID commentId;

  @Column(name = "task_id")
  private UUID taskId;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "comment")
  private String text;

  @Column(name = "created_at")
  private LocalDate createdAt;

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
