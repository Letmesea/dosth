package com.rabbitmqc.rabbitmqc.queue;


import com.entity.FlightBody;
import com.entity.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author Letmesea
 * @title: QueueMsgHandler
 * @projectName ceairMiniAppBackEnd
 * @description: 消息处理
 * @date 2020/6/29:56
 */
@Slf4j
@Service
public class QueueMsgHandlerImpl implements QueueMsgHandlerService{

    //@Autowired
    //注入推送服务

    /**
     *
     * @param flightBodyList
     */
    @Override
    public void exec(List<FlightBody> flightBodyList){

        try {
            /**
             * 消息推送
             */
            List<CompletableFuture<MessageResponse>> messageFutures = flightBodyList
                    .stream()
                    .map(flight -> CompletableFuture.supplyAsync(() -> {
                        try {
                            return push();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }))
                    .collect(Collectors.toList());

            /**
             * 线程等待，获取推送结果
             */
            List<MessageResponse> results = messageFutures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());
            /**
             * 更新状态
             * TODO results
             * 将更新的结果入库
             */
            updateMessageStatus(results);
        } catch (Exception e) {
            log.error("");
        }
    }
    /**
     * 将消息推送到微信服务通知
     * @return {@link MessageResponse}
     */
    public MessageResponse push() throws InterruptedException {
        Thread.sleep(300);
        return null;
    }

    /**
     * 保存消息推送状态到数据库
     * @param results
     */
    public void updateMessageStatus(List<MessageResponse> results) throws InterruptedException {
        Thread.sleep(50);
    }
}
