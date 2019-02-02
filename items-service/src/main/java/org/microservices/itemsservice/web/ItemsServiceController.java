package org.microservices.itemsservice.web;

import org.microservices.itemsservice.exception.ItemNotFoundException;
import org.microservices.itemsservice.model.Item;
import org.microservices.itemsservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/items")
    public ItemDto addItem(@RequestBody Item newItem) {
        return toItemDto(itemRepository.save(newItem));
    }

    @GetMapping(path = "/items/{id}", produces = "application/json")
    public ItemDto getItem(@PathVariable Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        return toItemDto(item);
    }

    @PutMapping(path = "/items/{id}", produces = "application/json")
    public ItemDto updateItem(@RequestBody Item changedItem, @PathVariable Long id) {
        Item item = itemRepository.findById(id)
                .map(employee -> {
                    employee.setName(changedItem.getName());
                    return itemRepository.save(employee);
                })
                .orElseGet(() -> {
                    changedItem.setId(null);
                    return itemRepository.save(changedItem);
                });

        return toItemDto(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }

    private ItemDto toItemDto(Item item) {
        int port = Integer.parseInt(environment.getProperty("local.server.port", "0"));
        return ItemDto.of(item, port);
    }
}
