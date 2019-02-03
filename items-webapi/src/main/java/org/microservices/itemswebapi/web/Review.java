package org.microservices.itemswebapi.web;

public class Review {

    private Long id;

    private String type;

    private Long typeId;

    private Integer rating;

    private Integer ratingMin;

    private Integer ratingMax;

    private String comment;

    private int port;

    public Review() {
    }

    public Review(Long id, String type, Long typeId, Integer rating, Integer ratingMin, Integer ratingMax, String comment, int port) {
        this.id = id;
        this.type = type;
        this.typeId = typeId;
        this.rating = rating;
        this.ratingMin = ratingMin;
        this.ratingMax = ratingMax;
        this.comment = comment;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRatingMin() {
        return ratingMin;
    }

    public void setRatingMin(Integer ratingMin) {
        this.ratingMin = ratingMin;
    }

    public Integer getRatingMax() {
        return ratingMax;
    }

    public void setRatingMax(Integer ratingMax) {
        this.ratingMax = ratingMax;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return String.format("Review{id=%d, type='%s', typeId=%d, rating=%d, ratingMin=%d, ratingMax=%d, comment='%s', port=%d}", id, type, typeId, rating, ratingMin, ratingMax, comment, port);
    }
}
