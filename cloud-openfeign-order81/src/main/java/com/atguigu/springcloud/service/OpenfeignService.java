package com.atguigu.springcloud.service;

import com.atguigu.entities.entities.vo.CommentResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author wz
 * @Date 2021/11/1 12:39
 * @Version 1.0
 */

/**
 * 1.当有多个FeignClient时可以使用name或value属性为其定义名称
 * 2.还可以用configuration来配置FeignClient
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = OpenfeignHandler.class)
@Service
public interface OpenfeignService{
    /**
     * PathVariable不能忽略
     *
     * @param id:openfeign会将该参数放到路径的{id}处
     * @return
     */
    @GetMapping("/payment/{id}")
    public CommentResult payment(@PathVariable("id") Long id);

    @GetMapping("/feign-timeout")
    public CommentResult feigntimeOut();



}
