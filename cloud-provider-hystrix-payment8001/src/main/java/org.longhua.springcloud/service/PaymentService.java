package org.longhua.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String payment_OK(Integer id){
        return "tset "+ Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler",commandProperties={
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String payment_TimeOut(Integer id){

        try {
//            int age = 10%0;
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "tset_timeout "+ Thread.currentThread().getName();
    }

    public String payment_TimeOutHandler(Integer id){
        return "timeout function";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            //@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期 用来隔多久恢复链路
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){

        if (id<0) {
            throw new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return "tset_熔断 "+ Thread.currentThread().getName()+uuid;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id不能为负数"+id;
    }

}
