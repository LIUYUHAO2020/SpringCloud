package com.atguigu.springcloud.services;

import com.atguigu.entities.entities.po.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wz
 * @Date 2021/10/28 18:21
 * @Version 1.0
 */
@Service
public class PaymentService implements PaymentServiceImpl {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Long create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentMapper.getPayment(id);
    }
}
