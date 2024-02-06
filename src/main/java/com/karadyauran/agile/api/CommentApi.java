package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.CommentDto;
import com.karadyauran.agile.entity.Comment;
import com.karadyauran.agile.validation.interf.Uuid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface CommentApi
{
    @GetMapping("comment/{id}")
    ResponseEntity<CommentDto> getComment(@Uuid @PathVariable UUID id);

    @GetMapping("comment")
    ResponseEntity<List<CommentDto>> getCommentsForTask(@Uuid @RequestParam UUID taskId);

    @PostMapping("comment/create")
    ResponseEntity<CommentDto> create(@RequestBody Comment comment);

    @PutMapping("comment/change-comment")
    ResponseEntity<CommentDto> changeComment(@Uuid @RequestParam UUID id, @NotNull @RequestParam String newComment);
}
