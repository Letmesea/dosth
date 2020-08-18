package com.rabbitmq.rabbitmq.component;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Slf4j
public class TestAsync {
    @Async
    public Future<String> dealHaveReturnTask() {
        try {
            log.info("异步开始...");
            Thread.sleep(30000);
            log.info("异步执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("thread", Thread.currentThread().getName());
        jsonObject.put("time", System.currentTimeMillis());
        return new AsyncResult<>(jsonObject.toJSONString());
    }
}

