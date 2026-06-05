package com.example.producttestinglesson.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorCategory<T>(
        LocalDateTime timeStamp,
        String message,
        T error,
        Integer status_code
) {
}
