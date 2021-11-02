package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wz
 * @Date 2021/11/2 14:28
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWay9557 {
    public static void main(String[] args) {
        SpringApplication.run(GateWay9557.class, args);
    }
}
