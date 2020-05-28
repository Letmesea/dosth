package com.rabbitmqc.rabbitmqc.conponent;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Letmesea
 * @title: FanoutReceiverC
 * @projectName dosth
 * @description: TODO
 * @date 2020/5/289:27
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverC消费者收到消息  : " +testMessage.toString());
    }
}
