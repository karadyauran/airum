package com.karadyauran.airum.web;

import com.karadyauran.airum.api.CommentApi;
import com.karadyauran.airum.dto.CommentDto;
import com.karadyauran.airum.entity.Comment;
import com.karadyauran.airum.service.interf.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Get Comment by ID",
            description = "Fetches a comment by its unique identifier.",
            tags = { "COMMENTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Comment found",
                            content = @Content(schema = @Schema(implementation = CommentDto.class))),
                    @ApiResponse(responseCode = "404", description = "Comment not found")
            })
    @Override
    public ResponseEntity<CommentDto> getComment(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getComment(id));
    }

    @Operation(summary = "Get Comments for Task",
            description = "Fetches all comments associated with a given task ID.",
            tags = { "COMMENTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Comments found",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CommentDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No comments found for the task")
            })
    @Override
    public ResponseEntity<List<CommentDto>> getCommentsForTask(UUID taskId)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getCommentsForTask(taskId));
    }

    @Operation(summary = "Create Comment",
            description = "Creates a new comment with the given details.",
            tags = { "COMMENTS" },
            requestBody = @RequestBody(description = "Comment details", required = true,
                    content = @Content(schema = @Schema(implementation = Comment.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Comment created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid comment details provided")
            })
    @Override
    public ResponseEntity<CommentDto> create(Comment comment)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.create(comment));
    }

    @Operation(summary = "Change Comment",
            description = "Updates the content of the specified comment.",
            tags = { "COMMENTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Comment updated",
                            content = @Content(schema = @Schema(implementation = CommentDto.class))),
                    @ApiResponse(responseCode = "404", description = "Comment not found")
            })
    @Override
    public ResponseEntity<CommentDto> changeComment(UUID id, String newComment)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeComment(id, newComment));
    }
}
