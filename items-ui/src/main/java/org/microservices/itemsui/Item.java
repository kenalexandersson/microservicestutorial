package org.microservices.itemsui;

public class Item {

    private Long id;

    private String name;

    private int port;

    public Item() {
    }

    public Item(Long id, String name, int port) {
        this.id = id;
        this.name = name;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return String.format("Item{id=%d, name='%s', port=%d}", id, name, port);
    }
}
