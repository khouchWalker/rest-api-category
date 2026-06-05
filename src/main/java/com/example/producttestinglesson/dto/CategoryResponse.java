package com.example.producttestinglesson.dto;

public record CategoryResponse(
        Integer id,
        String name,
        String description,
        boolean isActive
){
}
