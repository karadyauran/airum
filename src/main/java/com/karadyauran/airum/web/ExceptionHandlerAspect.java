package com.karadyauran.airum.web;


import com.karadyauran.airum.error.CommentWasNotFoundException;
import com.karadyauran.airum.error.EmailIsAlreadyExists;
import com.karadyauran.airum.error.ProjectWasNotFoundException;
import com.karadyauran.airum.error.RoleWasNotFoundException;
import com.karadyauran.airum.error.TaskWasNotFoundException;
import com.karadyauran.airum.error.UserWasNotFoundException;
import com.karadyauran.airum.error.UsernameIsAlreadyExists;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAspect
{
    @ExceptionHandler(UserWasNotFoundException.class)
    public ResponseEntity<String> handleUserWasNotFoundException(UserWasNotFoundException ex)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(UsernameIsAlreadyExists.class)
    public ResponseEntity<String> handleUsernameIsAlreadyExists(UsernameIsAlreadyExists ex)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(EmailIsAlreadyExists.class)
    public ResponseEntity<String> handleEmailIsAlreadyExists(EmailIsAlreadyExists ex)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(TaskWasNotFoundException.class)
    public ResponseEntity<String> handleTaskWasNotFoundException(TaskWasNotFoundException ex)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(RoleWasNotFoundException.class)
    public ResponseEntity<String> handleRoleWasNotFoundException(RoleWasNotFoundException ex)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ProjectWasNotFoundException.class)
    public ResponseEntity<String> handleProjectWasNotFoundException(ProjectWasNotFoundException ex)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }

    @ExceptionHandler(CommentWasNotFoundException.class)
    public ResponseEntity<String> handleCommentWasNotFoundException(CommentWasNotFoundException ex)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(ex.getMessage());
    }
}
