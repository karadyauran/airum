package com.karadyauran.agile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMember {
  @Id
  private UUID projectMemberId;
  private UUID userId;
  private UUID roleId;

  @OneToOne(mappedBy = "projectMember", targetEntity = Role.class)
  private Role role;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProjectMember that = (ProjectMember) o;
    return Objects.equals(projectMemberId, that.projectMemberId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectMemberId);
  }

  @Override
  public String toString() {
    return String.format("ProjectMember: %s, %s",
            userId, role);
  }
}
