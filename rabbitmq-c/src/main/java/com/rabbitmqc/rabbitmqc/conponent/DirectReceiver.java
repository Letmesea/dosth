package com.rabbitmqc.rabbitmqc.conponent;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Letmesea
 * @title: DirectReceiver
 * @projectName dosth
 * @description: 直连消息监听
 * @date 2020/5/2716:40
 */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {
    @RabbitHandler
    public void process(Map testMsg){
        System.out.println("消费TestDirectQueue队列数据："+testMsg.toString());
    }
}
