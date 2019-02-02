package org.microservices.itemswebapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemsWebApiExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ItemsWebApiException.class)
    @ResponseStatus(HttpStatus.OK)
    public String ItemUiExceptionHandler(ItemsWebApiException ex) {
        return ex.getMessage();
    }
}
