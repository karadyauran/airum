package com.karadyauran.agile.controller.page;

import com.karadyauran.agile.entity.Attachment;
import com.karadyauran.agile.service.interf.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controller")
@RequiredArgsConstructor
public class AttachmentController
{
    private final AttachmentService attachmentService;

    @GetMapping("/id={id}")
    public Attachment getAttachmentById(@PathVariable String id)
    {
        return attachmentService.getAttachmentById(id);
    }
}
