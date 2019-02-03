package org.microservices.itemswebapi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsWebApiController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemsServiceProxy itemsServiceProxy;

    @Autowired
    private ReviewsServiceProxy reviewsServiceProxy;

    @GetMapping(path = "/items-webapi/items")
    public List<Item> getItems() {
        List<Item> items = itemsServiceProxy.getItems();
        List<Review> reviews = reviewsServiceProxy.getReviews();


        LOGGER.info("{}", items);

        return items;
    }

    @GetMapping(path = "/items-webapi/items/{id}")
    public ItemInfoDto getItem(@PathVariable Long id) {

        Item item = itemsServiceProxy.getItem(id);
        List<Review> reviews = reviewsServiceProxy.getReviews("item", id);

        ItemInfoDto itemInfoDto = ItemInfoDto.of(item, reviews);

        LOGGER.info("{}", itemInfoDto);

        return itemInfoDto;
    }
}
