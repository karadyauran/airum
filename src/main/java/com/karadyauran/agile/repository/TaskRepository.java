package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.entity.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>
{
    @Query("SELECT t FROM Task t WHERE t.taskId = :taskId")
    Task findByTaskId(@PathVariable("taskId") UUID taskId);

    @Query("SELECT t FROM Task t WHERE t.status = :status")
    List<Task> findTaskByStatus(@PathVariable("status") TaskStatus status);

    @Query("select t from Task t")
    List<Task> getAllTasks();
}
