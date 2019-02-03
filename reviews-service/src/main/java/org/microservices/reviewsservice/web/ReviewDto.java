package org.microservices.reviewsservice.web;

import org.microservices.reviewsservice.model.Review;

public class ReviewDto {

    private Long id;

    private String type;

    private Long typeId;

    private Integer rating;

    private Integer ratingMin;

    private Integer ratingMax;

    private String comment;

    private int port;

    public static ReviewDto of(Review review, int port) {
        return new ReviewDto(review, port);
    }

    public ReviewDto(Review review, int port) {
        this.id = review.getId();
        this.type = review.getType();
        this.typeId = review.getTypeId();
        this.rating = review.getRating();
        this.ratingMin = review.getRatingMin();
        this.ratingMax = review.getRatingMax();
        this.comment = review.getComment();
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getRatingMin() {
        return ratingMin;
    }

    public Integer getRatingMax() {
        return ratingMax;
    }

    public String getComment() {
        return comment;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return String.format("ReviewDto{id=%d, type='%s', typeId=%d, rating=%d, ratingMin=%d, ratingMax=%d, comment='%s', port=%d}", id, type, typeId, rating, ratingMin, ratingMax, comment, port);
    }
}
