package org.microservices.webapi.web;

import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FeignExceptionAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String FeignExceptionHandler(FeignException ex) {
        LOGGER.warn(ex.getMessage());
        return "Item not available";
    }
}
