package org.microservices.itemsui;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemUiExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ItemsUiException.class)
    @ResponseStatus(HttpStatus.OK)
    public String ItemUiExceptionHandler(ItemsUiException ex) {
        return ex.getMessage();
    }
}
