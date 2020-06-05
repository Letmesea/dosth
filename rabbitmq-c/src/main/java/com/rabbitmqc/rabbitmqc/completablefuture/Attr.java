package com.rabbitmqc.rabbitmqc.completablefuture;

import lombok.Data;

/**
 * @author Letmesea
 * @title: Attr
 * @projectName dosth
 * @description: TODO
 * @date 2020/6/514:16
 */
@Data
public class Attr {
    private String id;
    Attr(String id){
        this.id = id;
    }
    @Override
    public String toString() {
        return "Attr{" +
                "id='" + id + '\'' +
                '}';
    }
}
