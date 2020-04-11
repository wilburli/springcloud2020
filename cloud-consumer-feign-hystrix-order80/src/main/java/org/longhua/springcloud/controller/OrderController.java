package org.longhua.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.longhua.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

public class OrderController extends BaseController{

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/consumer/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id){
        return orderService.payment_OK(id);
    }

    @GetMapping(value = "/consumer/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler",commandProperties = {
//    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String payment_TimeOut(@PathVariable("id") Integer id){
        return orderService.payment_TimeOut(id);
    }

    public String payment_TimeOutHandler(Integer id){
        System.out.println("testxxx-----------");
        return "对方服务器忙或自己方法出错请检查自己";
    }



}
