package org.microservices.itemsservice.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super(String.format("Failed to find item with id: %d", id));
    }
}
