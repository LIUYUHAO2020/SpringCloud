package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.po.Payment;
import com.atguigu.springcloud.entities.vo.CommentResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wz
 * @Date 2021/10/28 18:26
 * @Version 1.0
 */

/**
 * restTemplate:java的一个类
 * 提供了多种用于远程访问HTTP的便捷方法，spring提供的一种访问rest服务的《客户端》工具集
 * 供客户端调用服务端的
 *
 *
 * restTemplate.postForObject(PAYMENT_PATH+"/payment",payment,CommentResult.class);
 * 会将payment转换为JSON字符串，因此服务端需要@RequestBody注解
 *
 */
@Controller
@Slf4j
@ResponseBody
public class OrderController {

    public static final String PAYMENT_PATH="http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer")
    public CommentResult<Long> create(@RequestBody Payment payment) {
        log.info("Consumer***插入的信息为" + payment);
        return restTemplate.postForObject(PAYMENT_PATH+"/payment",payment,CommentResult.class);
    }

    @GetMapping("/consumer/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("Consumer***请求id为" + id);
        return restTemplate.getForObject(PAYMENT_PATH+"payment/"+id,CommentResult.class);
    }
}
