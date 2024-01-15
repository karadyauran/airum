package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.Attachment;
import com.karadyauran.agile.repository.AttachmentRepository;
import com.karadyauran.agile.service.interf.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService
{
    private final AttachmentRepository attachmentRepository;

    @Override
    public Attachment getAttachmentById(String id)
    {
        return attachmentRepository.findAttachmentByAttachmentId(UUID.fromString(id));
    }
}
