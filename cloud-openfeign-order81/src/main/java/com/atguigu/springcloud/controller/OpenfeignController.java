package com.atguigu.springcloud.controller;

import com.atguigu.entities.entities.vo.CommentResult;
import com.atguigu.springcloud.service.OpenfeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author wz
 * @Date 2021/10/30 19:24
 * @Version 1.0
 */
@Controller
@Slf4j
@ResponseBody
@RequestMapping("/openfeign")
public class OpenfeignController {

    @Autowired
    private OpenfeignService openfeignService;

    @GetMapping("/payment/{id}")
    public CommentResult payment(@PathVariable("id") Long id){
        log.info("信息进入openfeign");
        return openfeignService.payment(id);
    }

    @GetMapping("/feign-timeout")
    public CommentResult feigntimeOut(){
        return openfeignService.feigntimeOut();
    }

}
