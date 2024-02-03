package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.entity.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>
{
    Optional<List<Task>> findTasksByProjectId(UUID projectId);

    Optional<List<Task>> findTasksByProjectIdAndStatus(UUID projectId, TaskStatus status);

    @Modifying
    @Query("update Task t set t.title = :title where t.id = :id")
    void changeTaskTitle(UUID id, String title);

    @Modifying
    @Query("update Task t set t.description = :description where t.id = :id")
    void changeTaskDescription(UUID id, String description);

    @Modifying
    @Query("update Task t set t.assignedTo = :user where t.id = :id")
    void changeAssignToUser(UUID id, UUID user);

    @Modifying
    @Query("update Task t set t.dueTo = :dueTo where t.id = :id")
    void changeDueToDate(UUID id, Date dueTo);
}
