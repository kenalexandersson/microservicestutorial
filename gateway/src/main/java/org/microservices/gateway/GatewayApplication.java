package org.microservices.gateway;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayApplication.class);

//    @Bean
//    public LoggingFilter loggingFilter() {
//        return new LoggingFilter();
//    }

//    @Bean
//    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteLocator(DiscoveryClient discoveryClient, DiscoveryLocatorProperties discoveryLocatorProperties) {
//
//        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, discoveryLocatorProperties);
//    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("webapi-from-java", r -> r
//                        .path( "/webapi/**")
//                        .uri("lb://WEBAPI")
//                )
//                .build();
//    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}

