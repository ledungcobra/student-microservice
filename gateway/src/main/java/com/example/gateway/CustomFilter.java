package com.example.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static com.example.gateway.ObjectUtil.getOrDefault;

@Configuration
public class CustomFilter implements GlobalFilter {

    Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        var authToken = request.getHeaders()
                               .getFirst("Authorization");
        var url = getOrDefault(String.valueOf(request.getURI()), "");
        logger.info("Url = {}", url);
        if (url.contains("/api/student/")) {

        }
        logger.info("Authorization {}", authToken);
        return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        var response = exchange.getResponse();
                        logger.info("Post filter {}", response.getStatusCode());
                    }));
    }
}
