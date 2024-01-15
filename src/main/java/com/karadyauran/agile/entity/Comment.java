package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "task_comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tc_comment_id")
    private UUID commentId;

    @Column(name = "tc_task_id", insertable = false, updatable = false)
    private UUID taskId;

    @Column(name = "tc_user_id", insertable = false, updatable = false)
    private UUID userId;

    @Column(name = "tc_comment")
    private String text;

    @Column(name = "tc_created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JsonBackReference("commentTaskReference")
    @JoinColumn(name = "tc_task_id", referencedColumnName = "t_task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "tc_user_id", referencedColumnName = "u_user_id")
    private User commentUser;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(commentId);
    }

    @Override
    public String toString()
    {
        return String.format("Comment: %s, %s",
                taskId, text);
    }
}
