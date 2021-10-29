package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wz
 * @Date 2021/10/29 14:51
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class, args);
    }
}
