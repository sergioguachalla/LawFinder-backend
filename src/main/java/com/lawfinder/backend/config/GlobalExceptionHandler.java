package com.lawfinder.backend.config;

import com.amazonaws.Response;
import com.lawfinder.backend.config.exception.InvalidInputException;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ResponseDto<String>> handleInvalidInputException(InvalidInputException ex) {
        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setCode("9000");
        responseDto.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
