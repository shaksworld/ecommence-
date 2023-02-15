package com.ecommance.decaecommance.exception;

import com.ecommance.decaecommance.dto.response.ApiResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiGenericException.class})
    public ResponseEntity<Object> handleApiGenericException(ApiGenericException exception) {

        return ResponseEntity.status(400).body(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponse<Object>> handleGlobalExceptions(MethodArgumentNotValidException ex) {
        String[] errors = ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toArray(String[]::new);

        ApiResponse<Object> errorResponse = ApiResponse.builder()
                .data(errors)
                .message("please check the field below")
                .status("20")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
