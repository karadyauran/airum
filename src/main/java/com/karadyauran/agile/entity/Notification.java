package com.karadyauran.agile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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

    @Column(name = "n_sender_id")
    private UUID senderId;

    @Column(name = "n_receiver_id")
    private UUID receiverId;

    @Column(name = "n_notification_message")
    private String message;

    @Column(name = "n_created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "n_sender_id", referencedColumnName = "u_user_id")
    private User sender;

    @ManyToOne
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
