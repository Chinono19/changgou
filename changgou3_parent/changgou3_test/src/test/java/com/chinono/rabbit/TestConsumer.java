package com.chinono.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component      //将监听器交于spring容器
@RabbitListener(queues = "changgou_test")
public class TestConsumer {

    @RabbitHandler
    public void demo01(String message ){
        System.out.println("@@@@@@@@@@@@@@@@@: " + message);
    }

}