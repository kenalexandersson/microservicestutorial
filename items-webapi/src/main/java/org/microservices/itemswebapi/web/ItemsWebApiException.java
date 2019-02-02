package org.microservices.itemswebapi.web;

public class ItemsWebApiException extends RuntimeException {
    public ItemsWebApiException(Throwable throwable) {
        super(throwable);
    }
}
