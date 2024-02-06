package com.karadyauran.agile.dto;

import com.karadyauran.agile.dto.shortDto.UserShortDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto
{
    String comment;
    UserShortDto commenter;
    Boolean changed;
    Timestamp createdAt;
}
