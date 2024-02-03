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

    @Column(name = "task_id")
    UUID taskId;

    @Column(name = "user_id")
    UUID userId;

    @Column(name = "comment")
    String comment;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    Timestamp createdAt;
}
