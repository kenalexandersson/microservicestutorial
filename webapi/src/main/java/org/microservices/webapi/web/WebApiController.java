package org.microservices.webapi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WebApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebApiController.class);

    @Autowired
    private ItemsServiceProxy itemsServiceProxy;

    @Autowired
    private ReviewsServiceProxy reviewsServiceProxy;

    @GetMapping(path = "/webapi/items", produces = "application/json")
    public List<ItemInfoDto > getItems() {
        List<Item> items = itemsServiceProxy.getItems();
        List<Review> reviews = reviewsServiceProxy.getReviews("item");

        return items.stream()
                .map(item -> ItemInfoDto.of(item, reviews.stream()
                        .filter(review -> item.getId().equals(review.getTypeId()))
                        .collect(Collectors.toList())))
                .peek(dto -> LOGGER.info(dto.toString()))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/webapi/items/{id}", produces = "application/json")
    public ItemInfoDto getItem(@PathVariable Long id) {

        Item item = itemsServiceProxy.getItem(id);
        List<Review> reviews = reviewsServiceProxy.getReviews("item", id);

        ItemInfoDto itemInfoDto = ItemInfoDto.of(item, reviews);

        LOGGER.info(itemInfoDto.toString());

        return itemInfoDto;
    }
}
