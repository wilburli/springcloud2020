package org.longhua.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String payment_OK(Integer id){
        return "tset "+ Thread.currentThread().getName();
    }

    public String payment_TimeOut(Integer id){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "tset_timeout "+ Thread.currentThread().getName();
    }

}
