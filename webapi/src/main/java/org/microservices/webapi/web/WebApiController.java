package org.microservices.webapi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebApiController.class);

    @Autowired
    private ItemsServiceProxy proxy;

    @GetMapping(path = "/webapi/items")
    public List<Item> getItems() {
        List<Item> items = proxy.getItems();

        LOGGER.info("{}", items);

        return items;
    }

    @GetMapping(path = "/webapi/items/{id}")
    public Item getItem(@PathVariable Long id) {

        Item item = proxy.getItem(id);

        LOGGER.info("{}", item);

        return item;
    }
}
