package com.karadyauran.agile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
  @Id
  private UUID notificationId;
  private UUID senderId;
  private UUID receiverId;
  private String message;
  private LocalDate createdAt;
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
