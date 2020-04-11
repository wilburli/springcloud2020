package org.longhua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.longhua.springcloud.entities.CommonResult;
import org.longhua.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id){
        return paymentService.payment_OK(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id){
        return paymentService.payment_TimeOut(id);
    }


    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }



}
