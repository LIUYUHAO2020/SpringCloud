package com.atguigu.springcloud.sevice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author wz
 * @Date 2021/11/1 15:26
 * @Version 1.0
 */
@Service
@Slf4j
public class HystrixService {

    int number = 0;

    public String ok(Integer id) {
        log.info("第 " + (number++) + " 次请求, id: " + id);
        return "当前线程名称：" + Thread.currentThread().getName() + " id:" + id;
    }

    //HystrixCommand注解时spring-cloud-starter-hystrix中的注解
    @HystrixCommand(fallbackMethod = "errorHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String error(Integer id) {
        int num = 5;
        log.info("第 " + (number++) + " 次请求,id: " + id);
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (Exception e) {
            log.info("出现异常");
        }
        return "当前线程名称：" + Thread.currentThread().getName() + " id:" + id + " 处理时间：" + num;
    }

    public String errorHandler(Integer id) {
        log.info("第 " + (number++) + " 次请求,id: " + id);
        return "当前线程名称：" + Thread.currentThread().getName() + " id:" + id + " 处理方法：errorHandler";
    }

    //----------------------------------熔断器-----------------------------------------
    @HystrixCommand(fallbackMethod = "breakerHandler", commandProperties={
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="90")
    })
    public String breaker(int id) {
        if (id < 0) {
            throw new NullPointerException();
        } else {
            return "服务成功,id: " + id;
        }
    }

    public String breakerHandler(int id) {
        return "服务状况："+(id<0?"服务降级":"服务熔断，正常请求被降级处理")+"  id:" +id;
    }

}

