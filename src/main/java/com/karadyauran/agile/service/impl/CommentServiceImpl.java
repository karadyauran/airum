package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.Comment;
import com.karadyauran.agile.repository.CommentRepository;
import com.karadyauran.agile.service.interf.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService
{
    private final CommentRepository commentRepository;

    @Override
    public Comment getCommentById(String id)
    {
        return commentRepository.findCommentByCommentId(UUID.fromString(id));
    }
}
