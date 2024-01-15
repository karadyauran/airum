package com.karadyauran.agile.controller.page;

import com.karadyauran.agile.entity.Comment;
import com.karadyauran.agile.service.interf.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment/")
@RequiredArgsConstructor
public class CommentController
{
    private final CommentService commentService;

    @GetMapping("/id={id}")
    public Comment getCommentById(@PathVariable String id)
    {
        return commentService.getCommentById(id);
    }
}
