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
@Table(name = "notifications")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification
{
    @Id
    @UuidGenerator
    @Column(name = "id")
    UUID id;

    @Column(name = "sender")
    UUID sender;

    @Column(name = "receiver")
    UUID receiver;

    @Column(name = "message")
    String message;

    @CreationTimestamp
    @Column(name = "sent_at", updatable = false)
    Timestamp sentAt;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
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
                "%s: %s\nto %s",
                this.sender,
                this.message,
                this.receiver
        );
    }
}
