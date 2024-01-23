package com.karadyauran.agile.dto;

import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Tag(name = "Comment", description = "Dto for comment")
public class CommentDto
{
    String text;
    Task task;
    User commentUser;
}
