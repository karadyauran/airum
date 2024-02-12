package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserProjectRepository extends JpaRepository<UserProject, UUID>
{
    @Query("select u from UserProject u where u.userId = :userId and u.projectId = :projectId")
    UserProject findRoleForUser(UUID userId, UUID projectId);
}
