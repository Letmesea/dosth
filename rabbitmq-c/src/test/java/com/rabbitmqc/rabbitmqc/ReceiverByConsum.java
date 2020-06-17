package com.rabbitmqc.rabbitmqc;

import com.alibaba.fastjson.JSON;
import com.entity.FlightBody;
import com.rabbitmq.client.*;
import util.ByteToObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Letmesea
 * @title: ReceiverByConsum
 * @projectName dosth
 * @description: basicConsum模式，被动消费
 * @date 2020/6/1710:42
 */
public class ReceiverByConsum {
    private final static String QUEUE_NAME = "TestDirectQueue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setVirtualHost("p1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.basicQos(1);
        Consumer consumer = new Consumer() {
            @Override
            public void handleConsumeOk(String s) {

            }

            @Override
            public void handleCancelOk(String s) {

            }

            @Override
            public void handleCancel(String s) throws IOException {

            }

            @Override
            public void handleShutdownSignal(String s, ShutdownSignalException e) {

            }

            @Override
            public void handleRecoverOk(String s) {

            }

            @Override
            public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
//                System.out.println("接收消息 :   " + new String(bytes));\
                List<FlightBody> flightBodies=(List<FlightBody>) ByteToObject.byteToObject(bytes);
                System.out.println("接收到消息"+ JSON.toJSONString(flightBodies));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//消息确认
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME,consumer);
    }
}
