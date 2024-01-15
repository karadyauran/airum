package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Project
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "p_project_id")
    private UUID projectId;

    @Column(name = "p_owner_id", insertable = false, updatable = false)
    private UUID ownerId;

    @Column(name = "p_project_name")
    private String projectName;

    @Column(name = "p_description")
    private String description;

    @Column(name = "p_created_at")
    private LocalDate createdAt;

    @Column(name = "p_updated_at")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference("projectTasksReference")
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "p_owner_id", referencedColumnName = "u_user_id")
    @JsonManagedReference("projectOwnerReference")
    private User owner;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectId, project.projectId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(projectId);
    }

    @Override
    public String toString()
    {
        return String.format("Project: %s, %s, %s",
                projectId, projectName, createdAt);
    }
}
