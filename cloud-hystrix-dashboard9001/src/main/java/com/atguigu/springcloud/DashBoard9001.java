package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author wz
 * @Date 2021/11/1 23:45
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoard9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoard9001.class, args);
    }
}
