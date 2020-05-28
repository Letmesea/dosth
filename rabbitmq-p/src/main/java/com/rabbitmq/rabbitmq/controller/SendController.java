package com.rabbitmq.rabbitmq.controller;

import com.alibaba.fastjson.JSON;
import com.entity.OrderDto;
import com.utils.EncryptUtil;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author huangxunhui
 * Date: Created in 2020/3/11 10:27 下午
 * Utils: Intellij Idea
 * Description:
 */
@RestController
@AllArgsConstructor
public class SendController {

    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg/{count}")
    public void send(@PathVariable("count") Integer count) throws Exception {

        for (int i = 0; i < count; i++) {
            OrderDto orderDto = new OrderDto();
            orderDto.setId("P123456");
            orderDto.setMerchantId("M123456");
            orderDto.setAmount(BigDecimal.TEN);
            orderDto.setTradeTime("2020-03-11");

            String encryptOrderDto = EncryptUtil.encryptByAes(JSON.toJSONString(orderDto));

            rabbitTemplate.convertAndSend("order", encryptOrderDto);
        }
    }

    @GetMapping("/sendErrorMsg/{count}")
    public void sendErrorMsg(@PathVariable("count") Integer count) throws Exception {
        for (int i = 0; i < count; i++) {
            OrderDto orderDto = new OrderDto();
            orderDto.setId("P123456");
            orderDto.setMerchantId("M123456");
            orderDto.setAmount(BigDecimal.TEN);
            orderDto.setTradeTime("2020-03-11");

            rabbitTemplate.convertAndSend("order", JSON.toJSONString(orderDto));
        }
    }

    @Bean
    public Queue orderQueue(){
        return new Queue("order");
    }

}
