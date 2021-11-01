package com.atguigu.springcloud.controller;

import com.atguigu.entities.entities.vo.CommentResult;
import com.atguigu.springcloud.service.OpenfeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "defaultHandler")//定义默认的降级处理方法
public class OpenfeignController {

    @Autowired
    private OpenfeignService openfeignService;

    @GetMapping("/payment/{id}")
    @HystrixCommand
    public CommentResult payment(@PathVariable("id") Long id){
        log.info("信息进入openfeign");
        return openfeignService.payment(id);
    }

    /**
     * HystrixCommand注解放在controller中：
     *         使用的是openfeign为服务接口调用，service为接口无法创建处理方法
     * @return
     */
    @GetMapping("/feign-timeout")
    @HystrixCommand(fallbackMethod = "errorHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })//详细定义了降级方法的使用自身定义的
    public CommentResult feigntimeOut(){
        return openfeignService.feigntimeOut();
    }

    @GetMapping("/feign-timeout2")
    @HystrixCommand//未定义的使用默认的降级处理器
    public CommentResult feigntimeOut2(){
        return openfeignService.feigntimeOut();
    }

    //降级后调用的方法的返回值与参数必须与之前方法一致
    public CommentResult errorHandler(){
        CommentResult result =new CommentResult(500,"超时导致，消费者降级");
        return result;
    }

    public CommentResult defaultHandler(){
        CommentResult result =new CommentResult(500,"默认的降级处理器，消费者降级");
        return result;
    }

}
