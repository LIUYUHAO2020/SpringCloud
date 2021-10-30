package com.atguigu.springcloud;

import com.atguigu.myruler.MyRibbonRuler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author wz
 * @Date 2021/10/28 22:30
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MyRibbonRuler.class)
//针对微服务名为name的微服务采用configuration配置类的配置信息进行负载均衡
public class Order80 {
    public static void main(String[] args) {
        SpringApplication.run(Order80.class,args);
    }
}
