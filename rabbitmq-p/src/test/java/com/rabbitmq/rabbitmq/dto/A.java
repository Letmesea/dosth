package com.rabbitmq.rabbitmq.dto;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@Data
public class A {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String channel;
    private String payAmount;
    private List<String> as;

    private Integer it;


    public A(String channel, String payAmount){
        this.channel = channel;
        this.payAmount = payAmount;
    }
//    public A(String channel, String payAmount,List<String> as,Integer it){
//        this.channel = channel;
//        this.payAmount = payAmount;
//        this.as = as;
//        this.it = it;
//    }

    public A(){}

}
