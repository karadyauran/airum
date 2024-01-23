package com.karadyauran.agile.dto;

import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Tag(name = "Attachment", description = "Dto for attachment")
public class AttachmentDto
{
    Task task;
    User user;
    String attachmentType;
    String attachmentPath;
}
