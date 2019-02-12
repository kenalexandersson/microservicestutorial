package org.microservices.webapi.web;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
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
}