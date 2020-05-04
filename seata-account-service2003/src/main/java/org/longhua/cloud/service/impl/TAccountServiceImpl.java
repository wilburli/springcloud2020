package org.longhua.cloud.service.impl;

import org.longhua.cloud.mapper.TAccountMapper;
import org.longhua.cloud.service.TAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class TAccountServiceImpl implements TAccountService {
    @Resource
    private TAccountMapper accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        System.out.println("********->account-service中扣减账户余额开始");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId, money);
        System.out.println("********->account-service中扣减账户余额结束");
    }
}
