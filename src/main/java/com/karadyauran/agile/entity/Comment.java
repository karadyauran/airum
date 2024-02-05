package com.karadyauran.agile.entity;

import com.karadyauran.agile.validation.interf.Uuid;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "comments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment
{
    @Id
    @UuidGenerator
    @Column(name = "id")
    UUID id;

    @Uuid
    @Column(name = "task_id")
    UUID taskId;

    @Uuid
    @Column(name = "user_id")
    UUID userId;

    @NotNull
    @Column(name = "comment")
    String comment;

    @Column(name = "changed")
    boolean changed;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    User user;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
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
                this.comment,
                this.user
        );
    }
}
