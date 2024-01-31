package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.UserDto;
import com.karadyauran.agile.dto.shortDto.UserShortDto;
import com.karadyauran.agile.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {
        Timestamp.class,
        LocalDateTime.class
})
public interface UserMapper
{
    UserDto toDto(User user);

    UserShortDto map(UUID userId);

    List<UserDto> toDtoList(List<User> users);

    @Mapping(target = "registeredAt", expression = "java(Timestamp.valueOf(LocalDateTime.now()))")
    User toEntity(UserDto userDto);

    UUID map(UserShortDto value);
}
