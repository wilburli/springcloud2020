package org.longhua.cloud.service.impl;

import org.longhua.cloud.service.AccountService;
import org.longhua.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import org.longhua.cloud.domain.TOrder;
import org.longhua.cloud.mapper.TOrderMapper;
import org.longhua.cloud.service.TOrderService;

@Service
public class TOrderServiceImpl implements TOrderService{
    @Resource
    private TOrderMapper tOrderMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "abc_order_create", rollbackFor = Exception.class)
    public int create(TOrder order) {
        System.out.println("--------创建订单----------------");
        int num = tOrderMapper.creat(order);
        System.out.println("--------调用库存，扣减-----------");
        storageService.decrease(order.getProductId(), order.getCount());
        System.out.println("--------账户扣钱-----------------");
        accountService.decrease(order.getUserId(), BigDecimal.valueOf(order.getMoney()));

        System.out.println("------------修改订单状态---------");
        tOrderMapper.update(order.getUserId(), 0);
        System.out.println("------------下订单完成-----------");
        return num;
    }
}
