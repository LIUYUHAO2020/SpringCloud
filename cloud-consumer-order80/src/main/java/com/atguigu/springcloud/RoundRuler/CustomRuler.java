package com.atguigu.springcloud.RoundRuler;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wz
 * @Date 2021/10/30 16:38
 * @Version 1.0
 */

/**
 * 不用加Component注解
 * 在配置类中添加到IOC容器
 */
@Slf4j
public class CustomRuler extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerCyclicCounter;

    public CustomRuler() {
        this.nextServerCyclicCounter = new AtomicInteger(0);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    /**
     * this.getLoadBalancer():AbstractLoadBalancerRule实现的方法。
     * 交给重载的choose方法进行处理
     */
    @Override
    public Server choose(Object o) {
        log.info("进入自定义的RoundRuler");
        return this.choose(this.getLoadBalancer(), o);
    }

    public Server choose(ILoadBalancer lb, Object key){
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        } else {
            Server server = null;
            int count = 0;//十次轮询不出结果则为失败

            while (true) {
                //当找到server或次数过多时停止
                if (server == null && count++ < 10) {//没查找一次count++
                    int upNum = lb.getReachableServers().size();
                    int allNum = lb.getAllServers().size();
                    if (upNum != 0 && allNum != 0) {
                        int index = this.incrementAndGetModulo(allNum);//得到下一次访问微服务的下标
                        //判断该下表的服务是不是可用
                        server = lb.getAllServers().get(index);
                        if (server == null) {
                            Thread.yield();
                        } else {
                            if (server.isAlive()) {
                                return server;
                            }
                            server = null;
                        }
                        continue;
                    }

                    log.warn("No up servers available from load balancer: " + lb);
                    return null;
                }

                if (count >= 10) {
                    log.warn("No available alive servers after 10 tries from load balancer: " + lb);
                }
                return null;
            }

        }
    }

    /**
     *
     * @param modulo:对应微服务名称下服务的个数
     * @return
     */
    private int incrementAndGetModulo(int modulo) {
        int current;
        int next;
        do {
            current = this.nextServerCyclicCounter.get();//得到当前的下标
            next = (current + 1) % modulo;//得到要访问服务的的下标
        } while (!this.nextServerCyclicCounter.compareAndSet(current, next));
        //设置成功返回为true,取!为false停止自旋
        return next;
    }
}
