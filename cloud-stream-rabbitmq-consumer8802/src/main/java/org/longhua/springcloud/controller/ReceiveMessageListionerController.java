package org.longhua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListionerController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message){
        System.out.println("消费者1号："+message.getPayload()+"server port:"+port);
    }

}
