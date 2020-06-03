package com.rabbitmqc.rabbitmqc.queue;


import com.entity.FlightBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Logger;

/**
 * @description: 消费者线程执行器
 * @author: YUANBING1
 * @date: Created in 2020/5/8 16:30
 */
@Component
public class MessageConsumerExecutor {

    private final Logger logger = Logger.getLogger("MessageConsumerExecutor");
    private static CacheQueueThreadExecutor cacheQueueThreadExecutor;
    //队列初始容量-假定100
    private int capacity = 10;
    private int coreSize = Runtime.getRuntime().availableProcessors()+1;
//private int coreSize = 2;
    @Autowired
    private QueueMsgHandlerService queueMsgHandlerService;
    @PostConstruct
    public void init() {
        cacheQueueThreadExecutor = new CacheQueueThreadExecutor(coreSize,capacity,queueMsgHandlerService);
//        ExecutorService executor = new ThreadPoolExecutor(availableProcessors, availableProcessors,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>(),
//                new TripThreadFactory("trip thread"),
//                new ThreadPoolExecutor.AbortPolicy()
//        ){
//            @Override
//            protected void beforeExecute(Thread t, Runnable r) {
//                logger.fine(String.format("Thread %s: start %s", t, r));
//                super.beforeExecute(t, r);
//            }
//
//            @Override
//            protected void afterExecute(Runnable r, Throwable t) {
//                logger.fine(String.format("Thread %s: start %s", t, r));
//                super.afterExecute(r, t);
//            }
//
//            @Override
//            protected void terminated() {
//                super.terminated();
//            }
//        };
    }
    /**
     * 放入队列
     * @param message
     */
    public void putObj2Queue(List<FlightBody> message) {
        if (cacheQueueThreadExecutor != null) {
            cacheQueueThreadExecutor.putObject2Queue(message);
        }
    }
    public static CacheQueueThreadExecutor getCacheQueueThreadExecutor(){
        return cacheQueueThreadExecutor;
    }
}
