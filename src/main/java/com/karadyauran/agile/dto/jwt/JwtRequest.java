package com.karadyauran.agile.dto.jwt;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "This is your request to log in")
@NoArgsConstructor
public class JwtRequest {

    @Schema(description = "Username", example = "admin")
    private String username;

    @Schema(description = "Users password ", example = "12345678")
    private String password;
}
