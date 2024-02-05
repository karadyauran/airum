package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID>
{
    List<Project> findAllByName(String name);

    List<Project> findAllByCreatorId(UUID creatorId);

    @Modifying
    @Query("update Project p set p.name = :name where p.id = :id")
    void changeName(UUID id, String name);

    @Modifying
    @Query("update Project p set p.description = :description where p.id = :id")
    void changeDescription(UUID id, String description);

    @Modifying
    @Query("update Project p set p.creatorId = :creator where p.id = :id")
    void changeOwner(UUID id, UUID creator);
}
