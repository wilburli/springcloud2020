package org.longhua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.longhua.springcloud.entities.CommonResult;
import org.longhua.springcloud.entities.Payment;
import org.longhua.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/insertpayment")
    public CommonResult insertPayment(@RequestBody Payment payment){
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

    @GetMapping("/discovery")
    public Object getDiscoveryClient(){
        List<String> servers = discoveryClient.getServices();
        for (String ele:servers) {
            log.info("server...{}",ele);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instanceId...{}",instance.getInstanceId());
            log.info("host...{}",instance.getHost());
            log.info("uri...{}",instance.getUri());
        }

        return this.discoveryClient;

    }


    @GetMapping(value = "/payment/zipkin")
    public String zipkin(){

        return "zipkin test";
    }
}
