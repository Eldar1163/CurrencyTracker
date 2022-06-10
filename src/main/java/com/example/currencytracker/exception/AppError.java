package com.example.currencytracker.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class AppError {
    public HttpStatus status;
    public String message;

}
