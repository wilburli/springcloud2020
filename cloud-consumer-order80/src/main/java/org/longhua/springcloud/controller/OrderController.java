package org.longhua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.longhua.springcloud.entities.CommonResult;
import org.longhua.springcloud.entities.Payment;
import org.longhua.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/insertpayment")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/insertpayment",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/selectByPrimaryKey/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        System.out.println("id"+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/selectByPrimaryKey/"+id,CommonResult.class);

    }

    @GetMapping("/consumer/paymentFeign/selectByPrimaryKey/{id}")
    public CommonResult<Payment> getPaymentFeign(@PathVariable("id") Long id){
        System.out.println("feignid"+id);
        return paymentFeignService.getPayment(id);

    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentForEntity(@PathVariable("id") Long id){
        System.out.println("id"+id);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(0, "操作失败");
        }


    }

}
