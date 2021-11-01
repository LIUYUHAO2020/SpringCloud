package com.atguigu.springcloud.service;

import com.atguigu.entities.entities.vo.CommentResult;
import org.springframework.stereotype.Component;

/**
 * @Author wz
 * @Date 2021/11/1 22:10
 * @Version 1.0
 */

/**
 * 通过实现接口的方式进行
 * 降级方法与原始方法的解耦
 */
@Component
public class OpenfeignHandler implements  OpenfeignService{
    @Override
    public CommentResult payment(Long id) {
        return new CommentResult(400,"通过实现接口的方式进行降级处理payment");
    }

    @Override
    public CommentResult feigntimeOut() {
        return new CommentResult(400,"通过实现接口的方式进行降级处理feigntimeOut");
    }
}
