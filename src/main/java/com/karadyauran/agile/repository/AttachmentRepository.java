package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, UUID>
{
    Attachment findAttachmentByAttachmentId(UUID id);
}