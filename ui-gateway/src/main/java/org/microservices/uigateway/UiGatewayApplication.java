package org.microservices.uigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class UiGatewayApplication {

    @Bean
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(UiGatewayApplication.class, args);
    }

}

