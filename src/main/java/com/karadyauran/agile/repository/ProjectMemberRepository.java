package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, UUID>
{
    ProjectMember findProjectMemberByProjectMemberId(UUID id);
}
