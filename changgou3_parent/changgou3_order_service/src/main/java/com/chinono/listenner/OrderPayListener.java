package com.chinono.listenner;

import com.chinono.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RabbitListener(queues = "order_pay")
public class OrderPayListener {

    @Resource
    private OrderService orderService;

    @RabbitHandler
    public void updateOrderStatus(String sn){
        System.out.println(sn);
        orderService.updateOrderStatus(sn, "1");
    }
}
