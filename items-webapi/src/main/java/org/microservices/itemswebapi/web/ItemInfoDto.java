package org.microservices.itemswebapi.web;

import java.util.List;

public class ItemInfoDto {

    private Item item;
    private List<Review> reviews;
    private int itemPort;
    private int reviewPort;

    public static ItemInfoDto of(Item item, List<Review> reviews) {
        return new ItemInfoDto(item, reviews);
    }

    private ItemInfoDto(Item item, List<Review> reviews) {
        this.item = item;
        this.reviews = reviews;
        this.itemPort = item.getPort();
        this.reviewPort = !reviews.isEmpty() ? reviews.get(0).getPort() : 0;
    }

    public Item getItem() {
        return item;
    }

    public List<Review> getReview() {
        return reviews;
    }

    public int getItemPort() {
        return itemPort;
    }

    public int getReviewPort() {
        return reviewPort;
    }

    @Override
    public String toString() {
        return String.format("ItemInfoDto{item=%s, reviews=%s, itemPort=%d, reviewPort=%d}", item, reviews, itemPort, reviewPort);
    }
}
