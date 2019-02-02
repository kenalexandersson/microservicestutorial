package org.microservices.itemswebapi;

public class ItemsWebApiException extends RuntimeException {
    public ItemsWebApiException(Throwable throwable) {
        super(throwable);
    }
}
