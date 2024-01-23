package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.AttachmentDto;
import com.karadyauran.agile.entity.Attachment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttachmentMapper
{
    AttachmentDto toDto(Attachment attachment);
}
