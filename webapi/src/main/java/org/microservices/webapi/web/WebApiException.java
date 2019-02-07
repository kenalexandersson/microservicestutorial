package org.microservices.webapi.web;

public class WebApiException extends RuntimeException {
    public WebApiException(Throwable throwable) {
        super(throwable);
    }
}
