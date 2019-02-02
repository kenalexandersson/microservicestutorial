package org.microservices.uigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class UiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(UiGatewayApplication.class, args);
    }

}

