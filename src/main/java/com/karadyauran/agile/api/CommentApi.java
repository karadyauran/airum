package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.CommentDto;
import com.karadyauran.agile.entity.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface CommentApi
{
    @GetMapping("comment/{id}")
    ResponseEntity<CommentDto> getComment(@PathVariable UUID id);

    @GetMapping("comment")
    ResponseEntity<List<CommentDto>> getCommentsForTask(@RequestParam UUID taskId);

    @PostMapping("comment/create")
    ResponseEntity<CommentDto> create(@RequestBody Comment comment);

    @PutMapping("comment/change-comment")
    ResponseEntity<CommentDto> changeComment(@RequestParam UUID id, @RequestParam String newComment);
}
