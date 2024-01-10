package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.*;
import com.karadyauran.agile.entity.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "t_task_id")
    private UUID taskId;

    @Column(name = "t_project_id", insertable = false, updatable = false)
    private UUID projectId;

    @Column(name = "t_assigned_to_id", insertable = false, updatable = false)
    private UUID assignedToId;

    @Column(name = "t_created_by_id", insertable = false, updatable = false)
    private UUID createdById;

    @Column(name = "t_title")
    private String title;

    @Column(name = "t_description")
    private String description;

    @Column(name = "t_status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "t_created_at")
    private LocalDate createdAt;

    @Column(name = "t_due_to")
    private LocalDate dueDate;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "t_project_id", referencedColumnName = "p_project_id")
    private Project project;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "t_assigned_to_id", referencedColumnName = "u_user_id")
    private User assignedTo;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "t_created_by_id", referencedColumnName = "u_user_id")
    private User createdBy;

    @JsonManagedReference
    @OneToMany(mappedBy = "task")
    private List<Comment> taskComments;

    @JsonBackReference
    @OneToMany(mappedBy = "task")
    private List<Attachment> attachments;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(taskId, task.taskId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(taskId);
    }

    @Override
    public String toString()
    {
        return String.format("Task: %s, %s",
                title, status);
    }
}
