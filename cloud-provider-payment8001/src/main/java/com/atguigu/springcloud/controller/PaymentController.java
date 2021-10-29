package com.atguigu.springcloud.controller;

import com.atguigu.entities.entities.po.Payment;
import com.atguigu.entities.entities.vo.CommentResult;
import com.atguigu.springcloud.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wz
 * @Date 2021/10/28 18:26
 * @Version 1.0
 */
@Controller
@Slf4j
@ResponseBody
public class PaymentController {

    /**
     * 使用restful风格
     *      POST:insert
     *      GET:select
     *      PUT:update
     *      DELETE:delete
     */

    @Autowired
    private PaymentService paymentService;

    /**
     * @RequestBody注解:PostMan发送的请求必须时:content-type=application/json
     *
     * 1.context-type是application\json的请求体数据只能用@RequstBody接收
     *
     * 2.其他的数据只能用@RequstParam或者Bean接收,不能用@RequstBody接收
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment")
    public CommentResult<Long> create(@RequestBody Payment payment) {
        Long result = paymentService.create(payment);
        log.info("Provider***插入的信息为" + payment);
        if (result > 0) {
            return new CommentResult<Long>(200, "成功", payment.getId());
        } else {
            return new CommentResult<Long>(200, "插入失败", null);
        }

    }

    @GetMapping("/payment/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment result = paymentService.getPayment(id);
        log.info("Provider***查询到的结果为" + result);
        if (result == null) {
            return new CommentResult<Payment>(444, "结果不存在", null);
        } else {
            return new CommentResult<Payment>(200, "成功", result);
        }
    }
}
