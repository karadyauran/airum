package com.karadyauran.agile.entity;

import com.karadyauran.agile.entity.enums.TaskStatus;
import com.karadyauran.agile.validation.interf.StatusValidator;
import com.karadyauran.agile.validation.interf.Uuid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
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

    @Uuid
    @Column(name = "project_id")
    UUID projectId;

    @Size(min = 5, max = 60)
    @Column(name = "title")
    String title;

    @NotNull
    @Column(name = "description")
    String description;

    @StatusValidator
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    TaskStatus status;

    @Uuid
    @Column(name = "assigned_to")
    UUID assignedTo;

    @Uuid
    @Column(name = "created_by", updatable = false)
    UUID createdBy;

    @DateTimeFormat
    @Column(name = "due_to")
    Date dueTo;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    Project project;

    @ManyToOne
    @JoinColumn(name = "assigned_to", insertable = false, updatable = false)
    User assignedToUser;

    @ManyToOne
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    User createdByUser;

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
