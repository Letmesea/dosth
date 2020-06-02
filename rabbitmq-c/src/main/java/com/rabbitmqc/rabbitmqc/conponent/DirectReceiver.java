package com.rabbitmqc.rabbitmqc.conponent;

import com.entity.FlightBody;
import com.rabbitmq.client.Channel;
import com.rabbitmqc.rabbitmqc.queue.MessageConsumerExecutor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Letmesea
 * @title: DirectReceiver
 * @projectName dosth
 * @description: 直连消息监听
 * @date 2020/5/2716:40
 */
@Component


public class DirectReceiver {
    @RabbitListener(queues = "TestDirectQueue")
    public void process(List<FlightBody> testMsg, Message message, Channel channel) throws IOException, InterruptedException {
        System.out.println("消费TestDirectQueue队列数据："+testMsg.toString()+" " +
                "deliveryTag:"+message.getMessageProperties().getDeliveryTag());
        MessageConsumerExecutor.getCacheQueueThreadExecutor().putObject2Queue(testMsg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    @RabbitListener(queues = "TestDirectQueue2")
    public void process2(Map testMsg, Message message, Channel channel) throws IOException, InterruptedException {
        System.out.println("消费TestDirectQueue2队列数据："+testMsg.toString()+" " +
                "deliveryTag:"+message.getMessageProperties().getDeliveryTag());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
