package org.microservices.itemsservice.web;

import org.microservices.itemsservice.exception.ItemNotFoundException;
import org.microservices.itemsservice.model.Item;
import org.microservices.itemsservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ItemsServiceController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private Environment environment;

    @GetMapping(path = "/items", produces = "application/json")
    public List<ItemDto> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(this::toItemDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/items/{id}", produces = "application/json")
    public ItemDto getItem(@PathVariable Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        return toItemDto(item);
    }

    private ItemDto toItemDto(Item item) {
        int port = Integer.parseInt(environment.getProperty("local.server.port", "0"));
        return ItemDto.of(item, port);
    }
}
