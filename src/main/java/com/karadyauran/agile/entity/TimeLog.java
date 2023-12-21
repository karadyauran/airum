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
@Table(name = "time_log")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeLog {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "tl_time_log_id")
  private UUID timeLogId;

  @Column(name = "tl_task_id")
  private UUID taskId;

  @Column(name = "tl_user_id")
  private UUID userId;

  @Column(name = "tl_minute_spent")
  private int minuteSpent;

  @Column(name = "tl_log_date")
  private LocalDate logDate;

  @ManyToOne
  @JoinColumn(name = "tl_task_id", insertable = false, updatable = false)
  private Task task;

  @ManyToOne
  @JoinColumn(name = "tl_user_id", insertable = false, updatable = false)
  private User user;

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
