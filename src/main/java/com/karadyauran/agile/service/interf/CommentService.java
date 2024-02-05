package com.karadyauran.agile.service.interf;

import com.karadyauran.agile.dto.CommentDto;
import com.karadyauran.agile.entity.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService
{
    CommentDto getComment(UUID id);

    List<CommentDto> getCommentsForTask(UUID taskId);

    CommentDto create(Comment comment);

    CommentDto changeComment(UUID id, String newComment);
}
