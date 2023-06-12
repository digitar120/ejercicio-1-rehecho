package com.digitar120.ejercicio1rehecho.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BranchNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(BranchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String BranchNotFound(BranchNotFoundException ex){
        return ex.getMessage();
    }
}
