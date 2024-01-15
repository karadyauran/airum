package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @JsonManagedReference("projectTasksReference")
    private List<Task> tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("projectOwnerReference")
    @JoinColumn(name = "p_owner_id", referencedColumnName = "u_user_id")
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
