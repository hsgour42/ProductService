package com.example.productservice.controllers;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//ControllerAdvice stand between dispatcher and controller
@ControllerAdvice
public class ProductControllerAdvices {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(
            ProductNotFoundException productNotFoundException
    ){
        ExceptionDto exceptionDto = ExceptionDto
                .builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(productNotFoundException.getMessage())
                .build();
        return new ResponseEntity<>(exceptionDto , HttpStatus.NOT_FOUND);
    }
}
