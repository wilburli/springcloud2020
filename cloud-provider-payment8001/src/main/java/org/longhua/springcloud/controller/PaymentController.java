package org.longhua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.longhua.springcloud.entities.CommonResult;
import org.longhua.springcloud.entities.Payment;
import org.longhua.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/insertpayment")
    public CommonResult insertPayment(Payment payment){
        int count = paymentService.insert(payment);
        if(count>0){
            log.info("支付插入成功");
            return CommonResult.ok();
        }
        return CommonResult.err();
    }

    @GetMapping(value = "/selectByPrimaryKey/{id}")
    public CommonResult selectByPrimaryKey(@PathVariable("id") Long id){
        Payment payment = paymentService.selectByPrimaryKey(id);

        if (payment != null) {
            return CommonResult.ok(payment);
        }
        return CommonResult.ok("无对应数据");
    }

}
