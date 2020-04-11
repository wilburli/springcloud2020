package org.longhua.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = OrderServiceImpl.class)
public interface OrderService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String payment_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String payment_TimeOut(@PathVariable("id") Integer id);

}
