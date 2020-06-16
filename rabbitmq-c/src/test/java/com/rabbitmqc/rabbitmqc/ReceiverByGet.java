package com.rabbitmqc.rabbitmqc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.FlightBody;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Letmesea
 * @title: ReceiverByGet
 * @projectName dosth
 * @description: TODO
 * @date 2020/6/1617:46
 */
public class ReceiverByGet {
    private final static String QUEUE_NAME = "TestDirectQueue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.157.123");
        factory.setVirtualHost("p1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        while (true) {
            GetResponse resp = channel.basicGet(QUEUE_NAME, false);
            List<FlightBody> flightBody = (List<FlightBody>) ByteToObject(resp.getBody());
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
    private static Object ByteToObject(byte[] bytes) {
        Object obj = null;
        try {
            // bytearray to object
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);


            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }
}
