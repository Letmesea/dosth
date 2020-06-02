package com.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 不正常航班消息实体
 * @author: YUANBING1
 * @date: Created in 2020/5/9 14:53
 */
@Data
public class FlightMessage implements Serializable {

    private String airPhone;
    private String newArrDate;
    private String newArrPort;
    private String newArrSchedule;
    private String newDeptDate;
    private String newDeptPort;
    private String newDeptSchedule;
    private String newDeptYear;
    private String newFlightNo;
    private String newSubClassCd;
    private String oldArrPort;
    private String oldDeptPort;
    private String oldFlightDate;

    private String oldFlightNo;
    private String oldFlightYear;
    private String oldSubClassCd;
    private String passengerName;
    private String reason;
    private String smsContent;

}
