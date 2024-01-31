package com.karadyauran.agile.entity;

import com.karadyauran.agile.entity.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "tasks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task
{
    @Id
    @UuidGenerator
    @Column(name = "id")
    UUID id;

    @Column(name = "project_id")
    UUID project_id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    TaskStatus status;

    @Column(name = "assigned_to")
    UUID assignedTo;

    @Column(name = "created_by", updatable = false)
    UUID createdBy;

    @Column(name = "due_to")
    Date dueTo;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    Project project;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
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
                "%s: %s -> due to %s",
                this.title,
                this.description,
                this.dueTo
        );
    }
}
