package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.ProjectMemberDto;
import com.karadyauran.agile.entity.ProjectMember;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper
{
    ProjectMemberDto toDto(ProjectMember projectMember);
}
