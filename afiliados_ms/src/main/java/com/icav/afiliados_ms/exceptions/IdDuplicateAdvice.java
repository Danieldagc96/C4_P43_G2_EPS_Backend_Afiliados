package com.icav.afiliados_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class IdDuplicateAdvice {
    @ResponseBody
    @ExceptionHandler(IdDupliclateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String,String> EntityIdDuplicateAdvice(IdDupliclateException ex){
        Map response = new HashMap<>();
        response.put("Error",ex.getMessage());
        return response;
    }
}
