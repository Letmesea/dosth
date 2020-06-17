package com.rabbitmqc.rabbitmqc.conponent;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.index.qual.SameLen;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Letmesea
 * @title: AccountLogBatchListener
 * @projectName dosth
 * @description: 批量处理
 * @date 2020/6/1511:23
 */
@Component
@Slf4j
public class AccountLogBatchListener {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final ExecutorService executor = Executors.newFixedThreadPool(1);
    private static final int BATCH_SIZE = 100;

    @PostConstruct
    public void init(){
        executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                execute();
                return null;
            }
        });
    }

    private void execute(){
    }
}
