package com.rabbitmq.rabbitmq.dto;


public class A {
    private String channel;
    private String payAmount;
    public A(String channel,String payAmount){
        this.channel = channel;
        this.payAmount = payAmount;
    }
    public A(){}
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }
}
