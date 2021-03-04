package com.rabbitmq.rabbitmq.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class B {
    private String channel;
    @JSONField(name = "payAmount")
    private String refundAmount;
    public B(String channel,String refundAmount){
        this.channel = channel;
        this.refundAmount = refundAmount;
    }
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }
}
