package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.UserDto;
import com.karadyauran.agile.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);

    User toEntity(UserDto userDto);
}
