package com.rabbitmqc.rabbitmqc.queue;


import com.entity.FlightBody;

import java.util.List;

/**
 * @author Letmesea
 * @title: QueueMsgHandlerService
 * @projectName ceairMiniAppBackEnd
 * @description: TODO
 * @date 2020/6/210:29
 */
public interface QueueMsgHandlerService {
    void exec(List<FlightBody> flightBodyList);
}
