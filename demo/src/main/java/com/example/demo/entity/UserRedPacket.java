package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
public class UserRedPacket implements Serializable {
    private Long id;
    private Long redPacketId;
    private Long userId;
    private Double amount;
    private Timestamp grabTime;
    private String note;
}
