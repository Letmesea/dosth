//package com.rabbitmqc.rabbitmqc.conponent;
//
//import com.alibaba.fastjson.JSON;
//import com.entity.OrderDto;
//import com.rabbitmq.client.Channel;
//import com.utils.EncryptUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.support.AmqpHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * @author huangxunhui
// * Date: Created in 2020/3/11 9:54 下午
// * Utils: Intellij Idea
// * Description:
// */
//@Slf4j
//@Component
//public class ReceiveOrderMsg {
//
//    private static final String ORDER_QUEUE = "order";
//
//    @RabbitListener(queues = ORDER_QUEUE)
//    public void receiveOrder(@Payload String encryptOrderDto,
//                                          @Headers Map<String,Object> headers,
//                                          Channel channel) throws Exception {
//        // 解密和解析
//        String decryptOrderDto = EncryptUtil.decryptByAes(encryptOrderDto);
//        OrderDto orderDto = JSON.parseObject(decryptOrderDto, OrderDto.class);
//
//        try {
//
//            // 模拟推送
//            pushMsg(orderDto);
//        }catch (Exception e){
//            log.error("推送失败-错误信息:{},消息内容:{}", e.getLocalizedMessage(), encryptOrderDto);
//        }finally {
//            // 消息签收
//            channel.basicAck((Long) headers.get(AmqpHeaders.DELIVERY_TAG),false);
//        }
//
//    }
//
//    /**
//     * 模拟推送
//     * @param orderDto 订单信息
//     */
//    private void pushMsg(OrderDto orderDto) {
//        log.info("推送成功:{}",orderDto);
//    }
//}
