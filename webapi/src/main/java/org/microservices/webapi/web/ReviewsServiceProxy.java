package org.microservices.webapi.web;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "reviews-service", fallbackFactory = ReviewsServiceProxy.ReviewsServiceFeignClientFallbackFactory.class)
@RibbonClient(name = "reviews-service")
public interface ReviewsServiceProxy {

    @GetMapping("/reviews/{type}")
    List<Review> getReviews(@PathVariable String type);

    @GetMapping("/reviews/{type}/{typeid}")
    List<Review> getReviews(@PathVariable String type, @PathVariable Long typeid);

    @Component
    class ReviewsServiceFeignClientFallbackFactory implements FallbackFactory<ReviewsServiceProxy> {

        @Override
        public ReviewsServiceProxy create(Throwable throwable) {
            return new ReviewsServiceProxy() {
                @Override
                public List<Review> getReviews(@PathVariable String type) {
                    throw new WebApiException(throwable);
                }

                @Override
                public List<Review> getReviews(String type, Long typeid) {
                    throw new WebApiException(throwable);
                }
            };
        }
    }
}
