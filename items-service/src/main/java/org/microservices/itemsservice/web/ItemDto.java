package org.microservices.itemsservice.web;

import org.microservices.itemsservice.model.Item;

public class ItemDto {

    private Long id;
    private String name;
    private int port;

    public static ItemDto of(Item item, int port) {
        return new ItemDto(item.getId(), item.getName(), port);
    }

    public static ItemDto of(Long id, String name, int port) {
        return new ItemDto(id, name, port);
    }

    private ItemDto(Long id, String name, int port) {
        this.id = id;
        this.name = name;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return port;
    }
}
