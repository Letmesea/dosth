package com.rabbitmq.rabbitmq.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.platform.commons.util.StringUtils;

import java.util.List;

@Data
@AllArgsConstructor
public class B {
    private String channel;
    @JSONField(name = "payAmount")
    private String refundAmount;
    @JSONField(name = "as")
    private String as1;
    private String it;


    public B(String channel, String refundAmount){
        this.channel = channel;
        this.refundAmount = refundAmount;
    }
    public B(String channel, String refundAmount, List<String> as, String it){
        this.channel = channel;
        this.refundAmount = refundAmount;
        this.as1 = String.join("",as);
        this.it = it;
    }
}
