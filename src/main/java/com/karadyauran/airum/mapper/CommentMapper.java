package com.karadyauran.airum.mapper;

import com.karadyauran.airum.dto.CommentDto;
import com.karadyauran.airum.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper
{
    @Mapping(target = "commenter", source = "user")
    CommentDto toDto(Comment comment);

    @Mapping(target = "commenter", source = "user")
    List<CommentDto> toDtoList(List<Comment> comments);
}

