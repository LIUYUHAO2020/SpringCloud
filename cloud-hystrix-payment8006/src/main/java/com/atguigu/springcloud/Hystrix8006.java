package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wz
 * @Date 2021/11/1 15:34
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
/**
 * EnableCircuitBreaker：让HystrixCommand注解生效
 */
public class Hystrix8006 {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8006.class, args);
    }
}
