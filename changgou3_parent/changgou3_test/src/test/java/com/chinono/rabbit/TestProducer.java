package com.chinono.rabbit;

import com.chinono.TestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= TestApplication.class)
public class TestProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testDemo01(){
        rabbitTemplate.convertAndSend("","changgou_test","abc456");
    }
}