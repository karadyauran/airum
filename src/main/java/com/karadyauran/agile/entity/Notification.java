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
@Table(name = "notifications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
  @Id
  @Column(name = "notification_id")
  private UUID notificationId;

  @Column(name = "n_sender_id")
  private UUID senderId;

  @Column(name = "n_receiver_id")
  private UUID receiverId;

  @Column(name = "n_message")
  private String message;

  @Column(name = "n_created_at")
  private LocalDate createdAt;

  @Column(name = "n_is_read")
  private boolean isRead;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Notification that = (Notification) o;
    return Objects.equals(notificationId, that.notificationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notificationId);
  }

  @Override
  public String toString() {
    return String.format("Notification: %s, %s, '%s'", senderId, receiverId, message);
  }
}
