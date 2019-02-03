package org.microservices.reviewsservice.web;

import org.microservices.reviewsservice.exception.ReviewNotFoundException;
import org.microservices.reviewsservice.model.Review;
import org.microservices.reviewsservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReviewsServiceController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private Environment environment;

    @GetMapping(path = "/reviews", produces = "application/json")
    public List<ReviewDto> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(this::toReviewDto)
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/reviews")
    public ReviewDto addReview(@RequestBody Review newReview) {
        return toReviewDto(reviewRepository.save(newReview));
    }

    @GetMapping(path = "/reviews/{type}/{typeId}", produces = "application/json")
    public List<ReviewDto> getReviews(@PathVariable String type, @PathVariable Long typeId) {
        List<Review> reviews = reviewRepository.findByTypeAndTypeId(type, typeId)
                .orElseThrow(() -> new ReviewNotFoundException(type, typeId));

        return reviews.stream()
                .map(this::toReviewDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
    }

    private ReviewDto toReviewDto(Review review) {
        int port = Integer.parseInt(environment.getProperty("local.server.port", "0"));
        return ReviewDto.of(review, port);
    }
}
