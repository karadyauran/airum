package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>
{
    Optional<Role> findByNameAndProjectId(String name, UUID projectId);

    List<Role> findByProjectId(UUID id);

    @Modifying
    @Query("update Role r set r.name = :name where r.id = :id")
    void changeName(UUID id, String name);

    @Query("select r from Role r where r.id = :roleId and r.projectId = :projectId")
    Role findByUserIdAndProjectId(UUID roleId, UUID projectId);
}
