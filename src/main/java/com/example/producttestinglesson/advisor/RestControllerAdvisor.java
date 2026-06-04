package com.example.producttestinglesson.advisor;

import com.example.producttestinglesson.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestControllerAdvisor{

    // ExceptionHandler (NoSuchElementNotFound)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> NoSuchElementException (NoSuchElementException e) {
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
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse<?>> handleValidation(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error-> errors.put(error.getField(), error.getDefaultMessage()));
        // should use entity response for better message
        return new ResponseEntity<>(
                ErrorResponse.builder().
                        message("Provided data is valid")
                        .status_code(HttpStatus.BAD_REQUEST.value())
                        .error(errors)
                        .timeStamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST


        );

    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleMethodNot

}
