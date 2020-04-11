package org.longhua.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;

@DefaultProperties(defaultFallback = "global_TimeOutHandler")
public class BaseController {

    public String global_TimeOutHandler(){
        return "Global对方服务器忙或自己方法出错请检查自己";
    }
}
