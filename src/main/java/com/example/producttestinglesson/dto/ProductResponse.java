package com.example.producttestinglesson.dto;


public record ProductResponse (
        Integer id,
        String name,
        String description,
        Float price
) {}
