package com.example.semestralna_praca_vaii.controller.exception;
import com.example.semestralna_praca_vaii.facade.dto.error.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDto> resourceNotFound(ResourceNotFound e, HttpServletRequest request ) {
        ErrorDto errorDto = new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND.value(), List.of(e.getMessage()));
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ErrorDto> resourceAlreadyExists(Exception e, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(e.getMessage(), HttpStatus.CONFLICT.value(), List.of(e.getMessage()));
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.CONFLICT);
    }
}

