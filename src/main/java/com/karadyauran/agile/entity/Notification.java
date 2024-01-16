package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "n_notification_id")
    private UUID notificationId;

    @Column(name = "n_sender_id", insertable = false, updatable = false)
    private UUID senderId;

    @Column(name = "n_receiver_id", insertable = false, updatable = false)
    private UUID receiverId;

    @Column(name = "n_notification_message")
    private String message;

    @Column(name = "n_created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JsonBackReference("notificationSenderReference")
    @JoinColumn(name = "n_sender_id", referencedColumnName = "u_user_id")
    private User sender;

    @ManyToOne
    @JsonBackReference("notificationReceiverReference")
    @JoinColumn(name = "n_receiver_id", referencedColumnName = "u_user_id")
    private User receiver;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(notificationId, that.notificationId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(notificationId);
    }

    @Override
    public String toString()
    {
        return String.format("Notification: %s, %s, '%s'", senderId, receiverId, message);
    }
}
