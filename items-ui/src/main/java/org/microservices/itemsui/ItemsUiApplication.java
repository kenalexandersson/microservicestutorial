package org.microservices.itemsui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("org.microservices.itemsui")
@EnableDiscoveryClient
@SpringBootApplication
public class ItemsUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemsUiApplication.class, args);
    }
}

