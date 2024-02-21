package com.karadyauran.airum.mapper;

import com.karadyauran.airum.dto.UserDto;
import com.karadyauran.airum.dto.shortDto.UserShortDto;
import com.karadyauran.airum.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    // USER DTO
    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);

    User toEntity(UserDto dto);

    // USER SHORT DTO
    UserShortDto toShortDto(User user);

    List<UserShortDto> toShortDtoList(List<User> users);
}
