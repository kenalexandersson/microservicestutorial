package org.microservices.itemsservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.microservices.itemsservice.model.Item;

@Data
@AllArgsConstructor
public class ItemDto {

    private Long id;
    private String name;
    private int port;

    public static ItemDto of(Item item, int port) {
        return new ItemDto(item.getId(), item.getName(), port);
    }
}
