package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wz
 * @Date 2021/11/2 15:23
 * @Version 1.0
 */
@Configuration
public class GateWayConfig {
    /**
     * gateway网关配置类
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes().route("gateway_config1",
                r->r.path("/duniang").uri("https://baidu.com")).build();
    }
}
