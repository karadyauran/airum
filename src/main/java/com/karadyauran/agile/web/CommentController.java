package com.karadyauran.agile.web;

import com.karadyauran.agile.api.CommentApi;
import com.karadyauran.agile.dto.CommentDto;
import com.karadyauran.agile.entity.Comment;
import com.karadyauran.agile.service.interf.CommentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CommentController implements CommentApi
{
    CommentService service;

    @Override
    public ResponseEntity<CommentDto> getComment(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getComment(id));
    }

    @Override
    public ResponseEntity<List<CommentDto>> getCommentsForTask(UUID taskId)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getCommentsForTask(taskId));
    }

    @Override
    public ResponseEntity<CommentDto> create(Comment comment)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.create(comment));
    }

    @Override
    public ResponseEntity<CommentDto> changeComment(UUID id, String newComment)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeComment(id, newComment));
    }
}
