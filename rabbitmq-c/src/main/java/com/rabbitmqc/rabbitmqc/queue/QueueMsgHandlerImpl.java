package com.rabbitmqc.rabbitmqc.queue;


import com.entity.FlightBody;
import com.entity.MessageResponse;
import com.utils.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
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
    private AtomicInteger receiveN = new  AtomicInteger(0);
    //@Autowired
    //注入推送服务

    /**
     *
     * @param flightBodyList
     */
    @Override
    public void exec(List<FlightBody> flightBodyList){

        try {
            long a = System.currentTimeMillis();
            List<CompletableFuture<MessageResponse>> messageFutures = flightBodyList
                    .stream()
                    .map(flight -> CompletableFuture.supplyAsync(() -> {
                        try {
                            return push();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }))
                    .collect(Collectors.toList());
            List<MessageResponse> results = messageFutures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());


//            for (int i=0;i<flightBodyList.size();i++){
//                push();
//            }
            updateMessageStatus();

            System.out.println("单条推送时间ms "+(System.currentTimeMillis()-a));

        } catch (Exception e) {
            log.error("");
        }
    }
    /**
     * 将消息推送到微信服务通知
     * @return {@link MessageResponse}
     */
    public MessageResponse push() throws Exception {
//        System.out.println("---推送消息---");

        for(long i=0;i<30000000L;i++){
            i++;
        }

        return null;
    }

    /**
     * 保存消息推送状态到数据库
     */
    public void updateMessageStatus() throws InterruptedException {
        receiveN.getAndIncrement();
        System.out.println("---更新状态---已处理的消息数量 "+receiveN);
//        Thread.sleep(10);
    }
}
