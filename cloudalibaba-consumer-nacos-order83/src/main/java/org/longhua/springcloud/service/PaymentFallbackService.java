package org.longhua.springcloud.service;

import org.longhua.springcloud.entities.CommonResult;
import org.longhua.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{


    @Override
    public CommonResult paymentSQL(Long id) {
        return new CommonResult(444,"服务降级处理",new Payment(id,"error date"));
    }
}
