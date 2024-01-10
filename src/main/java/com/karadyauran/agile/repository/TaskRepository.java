package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>
{
    Task getTaskByTaskId(UUID taskId);
}
