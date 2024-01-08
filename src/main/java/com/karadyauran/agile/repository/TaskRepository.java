package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID>
{
    Task getTaskByTaskId(UUID id);
}
