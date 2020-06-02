package com.rabbitmqc.rabbitmqc.queue;

import com.entity.FlightBody;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Letmesea
 * @title: QueueHandleThread
 * @projectName ceairMiniAppBackEnd
 * @description: 队列消息处理线程
 * @date 2020/6/29:55
 */
@Slf4j
public class QueueHandleThread implements Runnable{
    private QueueMsgHandlerService queueMessageHandler;
    private LinkedBlockingQueue<List<FlightBody>> blockingQueue;
    QueueHandleThread(LinkedBlockingQueue blockingQueue, QueueMsgHandlerService queueMessageHandler) {
        super();
        this.blockingQueue = blockingQueue;
        this.queueMessageHandler=queueMessageHandler;
    }
    @Override
    public void run() {
        while (true){
            try{
                List<FlightBody> flightBodies = blockingQueue.take();
                queueMessageHandler.exec(flightBodies);
            }catch (Exception e){
                log.error("");
            }
        }
    }

}
