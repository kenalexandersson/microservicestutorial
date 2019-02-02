package org.microservices.itemswebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("org.microservices.itemswebapi")
@EnableDiscoveryClient
@SpringBootApplication
public class ItemsWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemsWebApiApplication.class, args);
    }
}
