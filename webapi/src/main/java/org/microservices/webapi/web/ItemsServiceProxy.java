package org.microservices.webapi.web;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "items-service", fallbackFactory = ItemsServiceProxy.ItemsServiceFeignClientFallbackFactory.class)
@RibbonClient(name = "items-service")
public interface ItemsServiceProxy {

    @GetMapping("/items")
    List<Item> getItems();

    @GetMapping("/items/{id}")
    Item getItem(@PathVariable Long id);

    @Component
    class ItemsServiceFeignClientFallbackFactory implements FallbackFactory<ItemsServiceProxy> {

        @Override
        public ItemsServiceProxy create(Throwable throwable) {
            return new ItemsServiceProxy() {
                @Override
                public List<Item> getItems() {
                    throw new WebApiException(throwable);
                }

                @Override
                public Item getItem(Long id) {
                    throw new WebApiException(throwable);
                }
            };
        }
    }
}
