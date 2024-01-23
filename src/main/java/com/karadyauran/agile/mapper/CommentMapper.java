package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.CommentDto;
import com.karadyauran.agile.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper
{
    CommentDto toDto(Comment comment);
}
