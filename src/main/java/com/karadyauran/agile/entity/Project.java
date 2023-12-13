package com.karadyauran.agile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
  @Id
  private UUID projectId;
  private String projectName;
  private UUID ownerId;
  private String description;
  private LocalDate createdAt;
  private Date deadline;

  @OneToMany(mappedBy = "project", targetEntity = ProjectMember.class)
  private List<ProjectMember> projectMembers;
  @OneToMany(mappedBy = "project", targetEntity = Task.class)
  private List<Task> tasks;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Project project = (Project) o;
    return Objects.equals(projectId, project.projectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId);
  }

  @Override
  public String toString() {
    return String.format("Project: %s, %s, %s, %s",
            projectId, projectName, createdAt, tasks);
  }
}
