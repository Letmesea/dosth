package com.rabbitmqc.rabbitmqc.conponent;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Letmesea
 * @title: FanoutReceiverA
 * @projectName dosth
 * @description: 扇形消费接收
 * @date 2020/5/289:22
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverA消费者收到消息  : " +testMessage.toString());
    }
}
