package com.rabbitmqc.rabbitmqc.queue;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class BalancedPutQueueConcreteStrategy {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void putObj(BlockingQueue[] queueArray, Object message) {
		if(queueArray==null || queueArray.length==0){
			return ;
		}
		if(message==null){
			return;
		}
		try {
			int minQueueId=0;
			int minQueueSize=queueArray[0].size();
			for(int i=1;i <queueArray.length;i++){
				if(queueArray[i].size()<minQueueSize){
					minQueueSize=queueArray[i].size();
					minQueueId=i;
				}
			}
			queueArray[minQueueId].put(message);
		} catch (InterruptedException e) {
			log.error("mq消息存入阻塞队列异常，{}", Throwables.getStackTraceAsString(e));
		}
	}

}
