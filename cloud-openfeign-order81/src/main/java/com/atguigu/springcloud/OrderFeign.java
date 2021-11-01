package com.atguigu.springcloud;

import com.atguigu.entities.entities.vo.CommentResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author wz
 * @Date 2021/10/30 18:31
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients//开启openfeign的注解
@EnableEurekaClient
@EnableHystrix//开启hystrix
public class OrderFeign {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign.class,args);
    }
}
