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
@Table(name = "time_log")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeLog {
  @Id
  @Column(name = "time_log_id")
  private UUID timeLogId;

  @Column(name = "task_id")
  private UUID taskId;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "minute_spent")
  private int minuteSpent;

  @Column(name = "log_date")
  private LocalDate logDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TimeLog timeLog = (TimeLog) o;
    return Objects.equals(timeLogId, timeLog.timeLogId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeLogId);
  }

  @Override
  public String toString() {
    return String.format("TimeLog: %s, %s",
            taskId, minuteSpent);
  }
}
