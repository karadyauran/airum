package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.RoleDto;
import com.karadyauran.agile.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper
{
    RoleDto toDto(Role role);
}
