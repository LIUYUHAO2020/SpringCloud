package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atguigu.springcloud.sevice.HystrixService;

/**
 * @Author wz
 * @Date 2021/11/1 15:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private HystrixService service;

    @GetMapping("/ok/{id}")
    public String ok(@PathVariable("id") int id){
        return service.ok(id);
    }

    @GetMapping("/error/{id}")
    public String error(@PathVariable("id") int id){
        return service.error(id);
    }
}
