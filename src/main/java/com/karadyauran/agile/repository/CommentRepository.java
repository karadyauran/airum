package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID>
{
    Comment findCommentByCommentId(UUID id);
}
