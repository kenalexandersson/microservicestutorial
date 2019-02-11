package org.microservices.webapi.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WebApiExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(WebApiException.class)
    @ResponseStatus(HttpStatus.OK)
    public String webApiExceptionHandler(WebApiException ex) {
        return ex.getMessage();
    }
}
