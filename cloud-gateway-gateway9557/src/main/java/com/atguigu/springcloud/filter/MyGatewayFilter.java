package com.atguigu.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author wz
 * @Date 2021/11/2 16:29
 * @Version 1.0
 */
@Component
public class MyGatewayFilter implements GlobalFilter, Ordered {
    /**
     * 全局过滤器,可以对访问服务的所有请求进行日志管理
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String username = request.getQueryParams().getFirst("username");
        if(username==null){
            exchange.getResponse().setStatusCode(HttpStatus.REQUEST_TIMEOUT);
            return exchange.getResponse().setComplete();
        }
        //继续执行过滤器链
        return chain.filter(exchange);
    }

    //过滤器顺序
    @Override
    public int getOrder() {
        return 0;
    }
}
