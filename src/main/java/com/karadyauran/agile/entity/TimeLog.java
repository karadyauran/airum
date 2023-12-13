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
public class TimeLog {
  @Id
  private UUID timeLogId;
  private UUID taskId;
  private UUID userId;
  private int minuteSpent;
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
