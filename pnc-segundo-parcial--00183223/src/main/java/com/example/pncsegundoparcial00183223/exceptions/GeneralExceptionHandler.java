package com.example.pncsegundoparcial00183223.exceptions;

import com.example.pncsegundoparcial00183223.domain.dtos.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(SpaceNotFoundException e){
        return buildErrorResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    public ResponseEntity<ApiErrorResponse> buildErrorResponse(Object message, HttpStatus status){
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();

        return ResponseEntity
                .status(status)
                .body(
                        ApiErrorResponse.builder()
                                .status(status.value())
                                .message(message)
                                .uri(uri)
                                .time(LocalDate.now())
                                .build()
                );
    }
}
