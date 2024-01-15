package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.karadyauran.agile.entity.enums.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;
import java.util.Objects;

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

    @Column(name = "t_project_id")
    private UUID projectId;

    @Column(name = "t_assigned_to_id")
    private UUID assignedToId;

    @Column(name = "t_created_by_id")
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference("projectTasksReference")
    @JoinColumn(name = "t_project_id", referencedColumnName = "p_project_id", insertable = false, updatable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference("taskAssignedToReference")
    @JoinColumn(name = "t_assigned_to_id", referencedColumnName = "u_user_id", insertable = false, updatable = false)
    private User assignedTo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference("taskCreatedTasksReference")
    @JoinColumn(name = "t_created_by_id", referencedColumnName = "u_user_id", insertable = false, updatable = false)
    private User createdBy;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    @JsonManagedReference("commentTaskReference")
    private List<Comment> taskComments;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    @JsonManagedReference("attachmentTaskReference")
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
