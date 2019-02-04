package org.microservices.itemswebapi.web;

import java.util.List;

public class ItemInfoDto {

    private Item item;
    private List<Review> reviews;

    public static ItemInfoDto of(Item item, List<Review> reviews) {
        return new ItemInfoDto(item, reviews);
    }

    private ItemInfoDto(Item item, List<Review> reviews) {
        this.item = item;
        this.reviews = reviews;
    }

    public Item getItem() {
        return item;
    }

    public List<Review> getReview() {
        return reviews;
    }


    @Override
    public String toString() {
        return String.format("ItemInfoDto{item=%s, reviews=%s}", item, reviews);
    }
}
