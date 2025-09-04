package com.pedronieto.java_template_kit.adapter.input.user;

import com.pedronieto.java_template_kit.adapter.exception.handler.response.ApiErroResponse;
import com.pedronieto.java_template_kit.adapter.input.user.dto.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "User Management", description = "Endpoints for managing users")
public interface SwaggerUserController {

    @Operation(
            summary = "Get a user by ID",
            description = "Retrieves the details of a specific user based on their unique identifier."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "User found successfully",
                    content = { @Content(schema = @Schema(implementation = UserResponse.class), mediaType = "application/json") }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User not found with the provided ID",
                    content = { @Content(schema = @Schema(implementation = ApiErroResponse.class), mediaType = "application/json") }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "An unexpected error occurred",
                    content = { @Content(schema = @Schema(implementation = ApiErroResponse.class), mediaType = "application/json") }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "An internal server error occurred",
                    content = { @Content(schema = @Schema(implementation = ApiErroResponse.class), mediaType = "application/json") }
            )
    })
    ResponseEntity<UserResponse> getUserById(
            @Parameter(
                    description = "The unique identifier of the user.",
                    required = true,
                    example = "1"
            )
            String id
    );
}