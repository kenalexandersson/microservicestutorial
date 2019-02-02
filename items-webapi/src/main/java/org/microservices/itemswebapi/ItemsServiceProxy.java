package org.microservices.itemswebapi;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "items-service", fallbackFactory = ItemsServiceProxy.ItemsServiceFeignClientFallbackFactory.class)
@RibbonClient(name = "items-service")
public interface ItemsServiceProxy {

    @GetMapping("/items/{id}")
    Item getItem(@PathVariable Long id);

    @Component
    class ItemsServiceFeignClientFallbackFactory implements FallbackFactory<ItemsServiceProxy> {

        @Override
        public ItemsServiceProxy create(Throwable throwable) {
            return id -> {
                throw new ItemsWebApiException(throwable);
            };
        }
    }
}
