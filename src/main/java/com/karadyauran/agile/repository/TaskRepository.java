package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>
{
    List<Task> findTasksByProjectId(UUID projectId);
}
