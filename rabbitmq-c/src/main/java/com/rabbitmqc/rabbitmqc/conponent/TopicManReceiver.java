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
// * @title: TopicManReceiver
// * @projectName dosth
// * @description: topic模式监听
// * @date 2020/5/2716:57
// */
//@Component
//@RabbitListener(queues = "topic.man")
//public class TopicManReceiver {
//    @RabbitHandler
//    public void process(Map testMessage) {
//        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
//    }
//}
