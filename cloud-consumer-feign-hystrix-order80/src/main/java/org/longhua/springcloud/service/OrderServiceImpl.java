package org.longhua.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public String payment_OK(Integer id) {
        return "feign  payment_OK 异常";
    }

    @Override
    public String payment_TimeOut(Integer id) {
        return  "feign  payment_TimeOut 异常";
    }
}
