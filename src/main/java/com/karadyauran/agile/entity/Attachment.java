package com.karadyauran.agile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "attachments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attachment
{
    @Id
    @UuidGenerator
    @Column(name = "id")
    UUID id;

    @Column(name = "name")
    String name;

    @Column(name = "path")
    String path;

    @Column(name = "task_id")
    UUID taskId;

    @Column(name = "user_id")
    UUID userId;

    @CreationTimestamp
    @Column(name = "attached_at", updatable = false)
    Timestamp attachedAt;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return Objects.equals(id, that.id);
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
                "%s -> %s",
                this.name,
                this.path
        );
    }
}
