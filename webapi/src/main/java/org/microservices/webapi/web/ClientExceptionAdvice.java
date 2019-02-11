package org.microservices.webapi.web;

import com.netflix.client.ClientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClientExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ClientException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String clientExceptionHandler(ClientException ex) {
        return ex.getMessage();
    }
}
