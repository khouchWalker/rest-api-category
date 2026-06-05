package com.example.producttestinglesson.advisor;

import com.example.producttestinglesson.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class CategoryRestControllerAdvisor {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse<?>> handleNoSuchElement(NoSuchElementException e) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .message(e.getMessage())
                        .status_code(HttpStatus.NOT_FOUND.value())
                        .timeStamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<?>> handleValidation(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .message("Provided data is not valid")
                        .status_code(HttpStatus.BAD_REQUEST.value())
                        .error(errors)
                        .timeStamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}