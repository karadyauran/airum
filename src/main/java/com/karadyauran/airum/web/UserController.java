package com.karadyauran.airum.web;

import com.karadyauran.airum.api.UserApi;
import com.karadyauran.airum.dto.UserDto;
import com.karadyauran.airum.dto.UserRegistrationDto;
import com.karadyauran.airum.service.interf.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "USERS", description = "Operations related to Users in the System")
public class UserController implements UserApi
{

    UserService service;

    @Operation(summary = "Gets user by their ID",
            description = "Returns UserDto entity for the specified user ID.",
            tags = { "USERS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "404", description = "User not found")
            },
            security = @SecurityRequirement(name = "bearerAuth"))
    @Override
    public ResponseEntity<UserDto> findById(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getUserById(id));
    }

    @Operation(summary = "Get User by Username",
            description = "Fetches a user by their username.",
            tags = { "USERS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found",
                            content = @Content(schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "404", description = "User not found")
            },
            security = @SecurityRequirement(name = "bearerAuth"))
    @Override
    public ResponseEntity<UserDto> findByIUsername(String username)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getUserByUsername(username));
    }

    @Operation(summary = "Find All Users",
            description = "Returns a list of all users in the system.",
            tags = { "USERS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Users found",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No users found")
            })

    @Override
    public ResponseEntity<List<UserDto>> findAll()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll());
    }

    @Operation(summary = "Change User's Username",
            description = "Updates the username of the specified user.",
            tags = { "USERS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Username updated successfully",
                            content = @Content(schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "404", description = "User not found")
            },
            security = @SecurityRequirement(name = "bearerAuth"))
    @Override
    public ResponseEntity<UserDto> changeUsername(UUID id, String username)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeUsername(id, username));
    }

    @Operation(summary = "Change User's Firstname",
            description = "Updates the firstname of the specified user.",
            tags = { "USERS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Firstname updated successfully",
                            content = @Content(schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "404", description = "User not found")
            },
            security = @SecurityRequirement(name = "bearerAuth"))
    @Override
    public ResponseEntity<UserDto> changeFirstname(UUID id, String firstname)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeFirstname(id, firstname));
    }

    @Operation(summary = "Change User's Surname",
            description = "Updates the surname of the specified user.",
            tags = { "USERS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Surname updated successfully",
                            content = @Content(schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "404", description = "User not found")
            },
            security = @SecurityRequirement(name = "bearerAuth"))
    @Override
    public ResponseEntity<UserDto> changeSurname(UUID id, String surname)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeSurname(id, surname));
    }

    @Operation(summary = "Change User's Email",
            description = "Updates the email of the specified user.",
            tags = { "USERS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Email updated successfully",
                            content = @Content(schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "404", description = "User not found")
            },
            security = @SecurityRequirement(name = "bearerAuth"))
    @Override
    public ResponseEntity<UserDto> changeEmail(UUID id, String email)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeEmail(id, email));
    }

    @Operation(summary = "Delete User by ID",
            description = "Deletes a user by their unique identifier.",
            tags = { "USERS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "User deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "User not found")
            },
            security = @SecurityRequirement(name = "bearerAuth"))
    @Override
    public ResponseEntity<Void> deleteById(UUID id)
    {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "Creates a new user",
            description = "Creates a new user in the system based on the provided UserRegistrationDto.",
            tags = { "USERS" },
            requestBody = @RequestBody(description = "User Registration Data", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserRegistrationDto.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "User created successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid user data provided")
            },
            security = @SecurityRequirement(name = "bearerAuth"))
    @Override
    public ResponseEntity<UserDto> create(UserRegistrationDto dto)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.create(dto));
    }
}
