package org.longhua.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.longhua.springcloud.entities.CommonResult;
import org.longhua.springcloud.entities.Payment;
import org.longhua.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class FlowLimitController {

    @Value("${server.port}")
    private static String serverPort;

    public static final String PAYMENT_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/testA")
    public String testA(){
        return "testA"+serverPort;
    }

    @GetMapping("/testB/{id}")
    @SentinelResource(value="testB",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handler1Exception",fallback = "handleFallBack",exceptionsToIgnore = {IllegalArgumentException.class})
    public String testB(@PathVariable("id") Long id){
        if(id == 4){
            throw new IllegalArgumentException("非法参数异常");
        }else if(id == 5){
            throw new NullPointerException("空指针异常");
        }
        restTemplate.getForObject(PAYMENT_URL+"/payment/nacos/"+id,String.class,id);
        return "testB";
    }

    public CommonResult handleFallBack(@PathVariable("id") Long id, Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult(444, e.getMessage(),payment);
    }

}
