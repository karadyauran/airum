package com.karadyauran.airum.web;

import com.karadyauran.airum.api.UserApi;
import com.karadyauran.airum.dto.UserDto;
import com.karadyauran.airum.service.interf.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
public class UserController implements UserApi
{
    UserService service;

    @Operation(summary = "Gets user by it's id",
            description = "Returns UserDto entity",
            tags = "USERS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<UserDto> findById(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getUserById(id));
    }

    @Operation(summary = "Gets user by it's username",
            description = "Returns UserDto entity",
            tags = "USERS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this fields for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<UserDto> findByIUsername(String username)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getUserByUsername(username));
    }

    @Operation(summary = "Finds all users in database",
            description = "Returns List of UserDto entities",
            tags = "USERS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<List<UserDto>> findAll()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll());
    }

    @Operation(summary = "Changes username for User",
            description = "Returns UserDto entity",
            tags = "USERS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<UserDto> changeUsername(UUID id, String username)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeUsername(id, username));
    }

    @Operation(summary = "Changes firstname for User",
            description = "Returns UserDto entity",
            tags = "USERS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<UserDto> changeFirstname(UUID id, String firstname)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeFirstname(id, firstname));
    }

    @Operation(summary = "Changes surname for User",
            description = "Returns UserDto entity",
            tags = "USERS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<UserDto> changeSurname(UUID id, String surname)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeSurname(id, surname));
    }

    @Operation(summary = "Changes email for User",
            description = "Returns UserDto entity",
            tags = "USERS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<UserDto> changeEmail(UUID id, String email)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeEmail(id, email));
    }

    // TODO translate on english

    /**
     * Этот каскадный тип применяет операцию remove()
     * всем связанным сущностям, когда родительская сущность удаляется.
     */
    @Override
    public ResponseEntity<Void> deleteById(UUID id)
    {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    // TODO translate on english
    @Operation(summary = "Creates new user",
            description = "UserDto would be the answer",
            tags = "USERS",
            requestBody = @RequestBody(
                    description = "USER'S DATA",
                    required = true, //обязательно ли тело запроса для сохранения
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class) // points on class,
                            // который служит примером реализации схемы для объекта API
                    )
            )
    )
    @Override
    public ResponseEntity<UserDto> create(UserDto dto)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.create(dto));
    }
}
