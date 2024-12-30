package com.ramkumar.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.util.List;
import java.util.Set;

@Component
public class MyFilter implements GlobalFilter {

    private ServerHttpRequest request;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("---Filter Excuted---");

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders header = request.getHeaders();
        Set<String> keySet = header.keySet();

        if(!keySet.contains("Secret")){
            throw new RuntimeException("Invalid Request");
        }

        List<String> list = header.get("Secret");

        assert list != null;
        if(!list.get(0).equals("ramkumar")){
            throw new RuntimeException("Invalid Request");
        }

        return chain.filter(exchange);
    }
}
