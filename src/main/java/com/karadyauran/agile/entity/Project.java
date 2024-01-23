package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "projects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "p_updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @JsonManagedReference("projectTasksReference")
    private List<Task> tasks;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonBackReference("projectOwnerReference")
    @JoinColumn(name = "p_owner_id", referencedColumnName = "u_user_id")
    private User owner;

    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private List<User> users;

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
