package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.RoleDto;
import com.karadyauran.agile.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper
{
    RoleDto toDto(Role role);

    List<RoleDto> toDtoList(List<Role> roles);

    Role toEntity(RoleDto role);
}