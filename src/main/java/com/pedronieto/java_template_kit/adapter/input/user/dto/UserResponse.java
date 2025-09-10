package com.pedronieto.java_template_kit.adapter.input.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserResponse(
        @Schema(description = "User identifier", example = "1")
        String id,
        @Schema(description = "User's name", example = "John Doe")
        String name,
        @Schema(description = "User's email", example = "johndoe@example.com")
        String email) {}
