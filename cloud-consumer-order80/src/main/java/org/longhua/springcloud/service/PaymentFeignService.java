package org.longhua.springcloud.service;

import org.longhua.springcloud.entities.CommonResult;
import org.longhua.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/selectByPrimaryKey/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
