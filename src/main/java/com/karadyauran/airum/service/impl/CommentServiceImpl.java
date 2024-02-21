package com.karadyauran.airum.service.impl;

import com.karadyauran.airum.dto.CommentDto;
import com.karadyauran.airum.entity.Comment;
import com.karadyauran.airum.error.CommentWasNotFoundException;
import com.karadyauran.airum.error.TaskWasNotFoundException;
import com.karadyauran.airum.error.UserWasNotFoundException;
import com.karadyauran.airum.error.message.ErrorMessage;
import com.karadyauran.airum.mapper.CommentMapper;
import com.karadyauran.airum.repository.CommentRepository;
import com.karadyauran.airum.repository.TaskRepository;
import com.karadyauran.airum.repository.UserRepository;
import com.karadyauran.airum.service.interf.CommentService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CommentServiceImpl implements CommentService
{
    CommentRepository commentRepository;
    TaskRepository taskRepository;
    UserRepository userRepository;

    CommentMapper mapper;

    @Override
    @Transactional
    public CommentDto getComment(UUID id)
    {
        return mapper.toDto(
                commentRepository.findById(id)
                        .orElseThrow(() -> new CommentWasNotFoundException(ErrorMessage.COMMENT_WAS_NOT_FOUND))
        );
    }

    @Override
    @Transactional
    public List<CommentDto> getCommentsForTask(UUID taskId)
    {
        if (taskIsNotExists(taskId))
        {
            throw new TaskWasNotFoundException(ErrorMessage.TASK_WAS_NOT_FOUND);
        }

        return mapper.toDtoList(
                commentRepository.findCommentsByTaskId(taskId)
        );
    }

    @Override
    @Transactional
    public CommentDto create(Comment comment)
    {
        UUID userId = comment.getUserId();

        if (userIsNotExists(userId))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        var taskId = comment.getTaskId();

        if (taskIsNotExists(taskId))
        {
            throw new TaskWasNotFoundException(ErrorMessage.TASK_WAS_NOT_FOUND);
        }

        commentRepository.save(comment);
        return mapper.toDto(comment);
    }

    @Override
    @Transactional
    public CommentDto changeComment(UUID id, String newComment)
    {
        if (commentIsNotExists(id))
        {
            throw new CommentWasNotFoundException(ErrorMessage.COMMENT_WAS_NOT_FOUND);
        }

        commentRepository.changeComment(id, newComment);
        commentRepository.changed(id);
        return mapper.toDto(
                commentRepository.findById(id)
                        .orElse(null)
        );
    }

    private boolean commentIsNotExists(UUID id)
    {
        return !commentRepository.existsById(id);
    }

    private boolean taskIsNotExists(UUID id)
    {
        return !taskRepository.existsById(id);
    }

    private boolean userIsNotExists(UUID id)
    {
        return !userRepository.existsById(id);
    }
}
