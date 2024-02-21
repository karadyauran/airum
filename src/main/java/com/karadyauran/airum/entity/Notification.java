package com.karadyauran.airum.entity;

import com.karadyauran.airum.validation.interf.Uuid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "notifications")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification
{
    @Id
    @UuidGenerator
    @Column(name = "id")
    UUID id;

    @Uuid
    @Column(name = "sender")
    UUID sender;

    @Uuid
    @Column(name = "receiver")
    UUID receiver;

    @NotNull
    @Column(name = "message")
    String message;

    @CreationTimestamp
    @Column(name = "sent_at", updatable = false)
    Timestamp sentAt;

    @ManyToOne
    @JoinColumn(name = "sender", updatable = false, insertable = false)
    User senderUser;

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
