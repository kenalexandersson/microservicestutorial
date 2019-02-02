package org.microservices.itemswebapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsWebApiController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemsServiceProxy proxy;

    @GetMapping(path = "/items-webapi/items/{id}")
    public Item getItem(@PathVariable Long id) {

        Item response = proxy.getItem(id);

        LOGGER.info("{}", response);

        return response;
    }
}
