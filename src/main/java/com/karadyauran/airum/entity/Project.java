package com.karadyauran.airum.entity;

import com.karadyauran.airum.validation.interf.Uuid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "projects")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project
{
    @Id
    @UuidGenerator
    @Column(name = "id")
    UUID id;

    @Uuid
    @Column(name = "creator_id")
    UUID creatorId;

    @Size(min = 5, max = 60)
    @Column(name = "name")
    String name;

    @NotNull
    @Column(name = "description")
    String description;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    Timestamp createdAt;

    @ManyToMany(mappedBy = "projects")
    List<User> users;

    @OneToMany(mappedBy = "project")
    List<Task> tasks;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return String.format(
                "'%s' created by %s",
                this.name,
                creatorId
        );
    }
}
