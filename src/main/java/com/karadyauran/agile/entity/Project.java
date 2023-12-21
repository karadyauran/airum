package com.karadyauran.agile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "projects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "p_project_id")
  private UUID projectId;

  @Column(name = "p_project_name")
  private String projectName;

  @Column(name = "p_owner_id")
  private UUID ownerId;

  @Column(name = "p_description")
  private String description;

  @Column(name = "p_created_at")
  private LocalDate createdAt;

  @Column(name = "p_deadline")
  private Date deadline;

  @OneToMany(mappedBy = "project")
  private Set<ProjectMember> projectMembers;

  @OneToMany(mappedBy = "project")
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
    return String.format("Project: %s, %s, %s",
            projectId, projectName, createdAt);
  }
}
