package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>
{
    @Query("SELECT t FROM Task t WHERE t.taskId = CAST(:taskId AS CHAR)")
    Task findByTaskId(@Param("taskId") UUID taskId);
}
