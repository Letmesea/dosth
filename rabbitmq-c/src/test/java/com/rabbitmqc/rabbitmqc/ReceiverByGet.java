package com.rabbitmqc.rabbitmqc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.FlightBody;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;
import util.ByteToObject;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Letmesea
 * @title: ReceiverByGet
 * @projectName dosth
 * @description: basicGet方式，主动消费
 * @date 2020/6/1617:46
 */
public class ReceiverByGet {
    private final static String QUEUE_NAME = "TestDirectQueu";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setVirtualHost("p1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        while (true) {
            GetResponse resp = channel.basicGet(QUEUE_NAME, false);
            List<FlightBody> flightBody = (List<FlightBody>) ByteToObject.byteToObject(resp.getBody());

            if (resp == null) {
                System.out.println("Get Nothing!");
                TimeUnit.MILLISECONDS.sleep(1000);
            } else {
                String message = new String(resp.getBody(), "UTF-8");
                System.out.printf(" [    %2$s<===](%1$s) %3$s\n", "Receiver", QUEUE_NAME, message);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        }
    }
}
