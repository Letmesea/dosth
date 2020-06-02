//package com.rabbitmqc.rabbitmqc.conponent;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * @author Letmesea
// * @title: FanoutReceiverB
// * @projectName dosth
// * @description: TODO
// * @date 2020/5/289:26
// */
//@Component
//@RabbitListener(queues = "fanout.B")
//public class FanoutReceiverB {
//    @RabbitHandler
//    public void process(Map testMessage) {
//        System.out.println("FanoutReceiverB消费者收到消息  : " +testMessage.toString());
//    }
//}
