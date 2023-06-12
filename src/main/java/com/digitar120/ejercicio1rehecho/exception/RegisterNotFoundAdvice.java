package com.digitar120.ejercicio1rehecho.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RegisterNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(RegisterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String handlerRegisterNotFound(RegisterNotFoundException ex) {
        return ex.getMessage();
    }
}
