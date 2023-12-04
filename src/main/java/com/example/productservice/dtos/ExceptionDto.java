package com.example.productservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ExceptionDto {
    private HttpStatus httpStatus;
    private String message;
}
