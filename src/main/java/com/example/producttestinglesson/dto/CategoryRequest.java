package com.example.producttestinglesson.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CategoryRequest(
        @NotBlank (message = "Name is required")
        @Positive(message= "Name must be filled")
        String name,
        @NotBlank(message = "Description is required")
        @Positive(message = "Description must be filled")
        String description,
        @NotNull(message = "isActive is required")
        @Positive(message = "isActive must be filled")
        boolean isActive

){
}
