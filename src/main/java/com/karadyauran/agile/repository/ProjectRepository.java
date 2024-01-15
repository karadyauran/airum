package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Project;
import com.karadyauran.agile.service.interf.ProjectService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID>
{
    Project findProjectByProjectId(UUID id);
}
