package com.rabbitmqc.rabbitmqc.queue;

import com.entity.FlightBody;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

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
    private int queueIndex;
    QueueHandleThread(LinkedBlockingQueue blockingQueue, QueueMsgHandlerService queueMessageHandler,int index) {
        super();
        this.blockingQueue = blockingQueue;
        this.queueMessageHandler=queueMessageHandler;
        this.queueIndex = index;
    }
    @Override
    public void run() {
        while (true){
            try{
                //take 没有任务则阻塞等待,poll 没有返回null,会一直占用
                List<FlightBody> flightBodies = blockingQueue.take();
//                List<FlightBody> flightBodies = blockingQueue.poll();
                System.out.println("线程 "+Thread.currentThread().getName()+" 执行队列 "+queueIndex+" 队列大小 "+blockingQueue.size());
                System.out.println("线程池活动线程数 "+((ThreadPoolExecutor)MessageConsumerExecutor.getCacheQueueThreadExecutor().getExecutorService()).getActiveCount());

                queueMessageHandler.exec(flightBodies);
            }catch (Exception e){
                log.error("");
            }
        }
    }

}
