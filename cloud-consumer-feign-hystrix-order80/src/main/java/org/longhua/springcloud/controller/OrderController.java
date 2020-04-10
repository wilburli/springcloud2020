package org.longhua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.longhua.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/consumer/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id){
        return orderService.payment_OK(id);
    }

    @GetMapping(value = "/consumer/hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id){
        return orderService.payment_TimeOut(id);
    }
}
