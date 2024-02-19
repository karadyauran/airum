package com.karadyauran.airum.mapper;

import com.karadyauran.airum.dto.RoleDto;
import com.karadyauran.airum.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper
{
    RoleDto toDto(Role role);

    List<RoleDto> toDtoList(List<Role> roles);
}