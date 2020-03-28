package org.longhua.springcloud.service.impl;

import org.longhua.springcloud.dao.PaymentMapper;
import org.longhua.springcloud.entities.Payment;
import org.longhua.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends BaseServiceImpl<Payment> implements PaymentService  {
    @Autowired
    PaymentMapper paymentDao;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(paymentDao);
    }

}
