package com.atguigu.springcloud.services;

import com.atguigu.entities.entities.po.Payment;
import org.springframework.stereotype.Service;

/**
 * @Author wz
 * @Date 2021/10/28 18:21
 * @Version 1.0
 */
@Service
public interface PaymentServiceImpl {
    public Long create(Payment payment);
    public Payment getPayment(Long id);
}
