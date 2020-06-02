package com.rabbitmqc.rabbitmqc.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Letmesea
 * @title: CacheQueueThreadExecutor
 * @projectName ceairMiniAppBackEnd
 * @description:缓冲消息线程池
 * @date 2020/6/29:39
 */
@Slf4j
public class CacheQueueThreadExecutor {
    //队列数组
    private LinkedBlockingQueue[] queueArray;
    //线程数组
    private QueueHandleThread[] threadArray;
    private ExecutorService executorService;
    /* 队列容量 */
    private Integer queueCapacity;
    // 核心线程数
    private Integer threadNum;
    //消息入队策略
    private BalancedPutQueueConcreteStrategy putObjStrategy;
    private QueueMsgHandlerService queueMessageHandler;

     public CacheQueueThreadExecutor(Integer threadNum, Integer queueCapacity, QueueMsgHandlerService queueMessageHandler) {
        this(threadNum,queueCapacity,queueMessageHandler,new BalancedPutQueueConcreteStrategy());
    }

     private CacheQueueThreadExecutor(Integer threadNum, Integer queueCapacity, QueueMsgHandlerService queueMessageHandler,
                                      BalancedPutQueueConcreteStrategy putQueueStrategy) {
        super();
        this.threadNum = threadNum;
        this.queueCapacity = queueCapacity;
        this.queueMessageHandler = queueMessageHandler;
        this.putObjStrategy = putQueueStrategy;

        init();
    }
    private void init() {
        queueArray =  new LinkedBlockingQueue[threadNum];
        threadArray = new QueueHandleThread[threadNum];
        executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) { // 初始化
//            queueArray[i] =  new LinkedBlockingQueue(queueCapacity);
            queueArray[i] =  new LinkedBlockingQueue();
            threadArray[i] = new QueueHandleThread(queueArray[i], queueMessageHandler);
            executorService.submit(threadArray[i]);
        }

    }
    public void putObject2Queue(Object message ){
        try {
            putObjStrategy.putObj(queueArray, message);;
        } catch (Exception e) {
            log.error("put message error!",e);
        }
    }
}
