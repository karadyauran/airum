package com.karadyauran.airum.repository;

import com.karadyauran.airum.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID>
{
    List<Comment> findCommentsByTaskId(UUID taskId);

    @Modifying
    @Query("update Comment c set c.comment = :newComment where c.id = :id")
    void changeComment(UUID id, String newComment);

    @Modifying
    @Query("update Comment c set c.changed = true where c.id = :id")
    void changed(UUID id);
}
