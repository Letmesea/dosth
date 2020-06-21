package com.rabbitmqc.rabbitmqc.conponent;

import com.alibaba.fastjson.JSON;
import com.entity.FlightBody;
import com.rabbitmq.client.Channel;
import com.rabbitmqc.rabbitmqc.queue.MessageConsumerExecutor;
import com.rabbitmqc.rabbitmqc.utils.ByteToObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Letmesea
 * @title: DirectReceiver
 * @projectName dosth
 * @description: 直连消息监听
 * @date 2020/5/2716:40
 */
@Component


public class DirectReceiver {
    private AtomicInteger receiveN = new  AtomicInteger(0);
    @RabbitListener(queues = "TestDirectQueue")
    public void process(List<FlightBody> testMsg, Message message, Channel channel) throws IOException, InterruptedException {

//        MessageConsumerExecutor.getCacheQueueThreadExecutor().putObject2Queue(testMsg);

        long a = System.currentTimeMillis();
//        for (int i=0;i<testMsg.size();i++){
//            push();
//        }
        List<FlightBody> flightBodies=JSON.parseArray(new String(message.getBody()),FlightBody.class);
        receiveN.getAndIncrement();
        System.out.println("单条推送时间ms "+(System.currentTimeMillis()-a));
        System.out.println("已处理的消息数量 "+receiveN);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println("");
    }
    public void push(){
        for(long i=0;i<30000000L;i++){
            i++;
        }
    }
//    @RabbitListener(queues = "TestDirectQueue2")
    public void process2(Map testMsg, Message message, Channel channel) throws IOException, InterruptedException {
        System.out.println("消费TestDirectQueue2队列数据："+testMsg.toString()+" " +
                "deliveryTag:"+message.getMessageProperties().getDeliveryTag());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
