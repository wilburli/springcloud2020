package org.longhua.cloud.controller;

import org.longhua.cloud.domain.TOrder;
import org.longhua.cloud.service.TOrderService;
import org.longhua.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private TOrderService tOrderService;

    @GetMapping("/order/create")
    public CommonResult<Integer> create(TOrder order) {
        int num = tOrderService.create(order);
        return new CommonResult<Integer>(200, "订单创建完成", num);
    }
}
