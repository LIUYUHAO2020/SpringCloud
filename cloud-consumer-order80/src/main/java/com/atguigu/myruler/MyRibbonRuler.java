package com.atguigu.myruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wz
 * @Date 2021/10/30 14:49
 * @Version 1.0
 */

/**
 * 配置新的负载均衡规则
 * 不能放在ComponentScan注解可以扫描到的包下，否则无法个性配置
 */
@Configuration
public class MyRibbonRuler {
    @Bean
    public IRule myRuler(){
        return new RandomRule();
    }
}
