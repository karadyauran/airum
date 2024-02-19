package com.karadyauran.airum.repository;

import com.karadyauran.airum.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID>
{
    @Query("select n from Notification n where (n.receiver = :user1 and n.sender = :user2) or (n.receiver = :user2 and n.sender = :user1)")
    List<Notification> findAllByIds(UUID user1, UUID user2);
}
