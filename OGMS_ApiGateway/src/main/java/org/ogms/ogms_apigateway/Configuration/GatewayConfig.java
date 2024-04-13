package org.ogms.ogms_apigateway.Configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        Mono<String> username = ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getName);

        return builder
                .routes()

                .route("httpbin", fn -> fn
                        .path("/get")
//                        .filters(f -> f
//                                .addRequestHeader("username", String.valueOf(username))
//                                .removeRequestHeader("Authorization"))
                        .uri("https://httpbin.org"))

                .route("ProductMicroservice", fn -> fn
                        .path("/api/v1/product/**")
                        .filters(f -> f
                                .removeRequestHeader("Authorization"))
                        .uri("http://localhost:9001"))

                .route("CartMicroservice", fn -> fn
                        .path("/api/v1/cart/**")
                        .uri("http://localhost:9002"))

                .route("OrderMicroservice", fn -> fn
                        .path("/api/v1/order/**")
                        .uri("http://localhost:9003"))
                .build();
    }
}