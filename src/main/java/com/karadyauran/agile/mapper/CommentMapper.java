package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.CommentDto;
import com.karadyauran.agile.entity.Comment;
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

