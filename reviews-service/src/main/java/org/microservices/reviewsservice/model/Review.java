package org.microservices.reviewsservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {

    @Id
    private Long id;

    private String type;

    @Column(name = "type_id")
    private Long typeId;

    private Integer rating;

    @Column(name = "rating_min")
    private Integer ratingMin;

    @Column(name = "rating_max")
    private Integer ratingMax;

    private String comment;

    public Review() {
    }

    public Review(Long id, String type, Long typeId, Integer rating, Integer ratingMin, Integer ratingMax, String comment) {
        this.id = id;
        this.type = type;
        this.typeId = typeId;
        this.rating = rating;
        this.ratingMin = ratingMin;
        this.ratingMax = ratingMax;
        this.comment = comment;
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

    @Override
    public String toString() {
        return String.format("Review{id=%d, type='%s', typeId=%d, rating=%d, ratingMin=%d, ratingMax=%d, comment='%s'}", id, type, typeId, rating, ratingMin, ratingMax, comment);
    }
}
