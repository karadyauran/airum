package com.karadyauran.agile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeLog {
  private UUID id;
  private UUID taskId;
  private UUID userId;
  private int minuteSpent;
  private LocalDate logDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TimeLog timeLog = (TimeLog) o;
    return Objects.equals(id, timeLog.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
