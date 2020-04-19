package org.longhua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.longhua.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class SendMessageController {

    @Resource
    IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
