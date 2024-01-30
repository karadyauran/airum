package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.UserDto;
import com.karadyauran.agile.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", imports = {
        Timestamp.class,
        LocalDateTime.class
})
public interface UserMapper
{
    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);

    @Mapping(target = "registeredAt", expression = "java(Timestamp.valueOf(LocalDateTime.now()))")
    User toEntity(UserDto userDto);
}
