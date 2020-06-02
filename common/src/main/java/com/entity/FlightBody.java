package com.entity;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: YUANBING1
 * @date: Created in 2020/5/9 15:42
 */
@Data
public class FlightBody {

    private String ffpNbr;

    private String idNbr;

    private List<FlightMessage> messages;

}
