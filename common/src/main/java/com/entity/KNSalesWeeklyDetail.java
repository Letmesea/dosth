package com.entity;

import lombok.Data;

import java.util.List;

/**
 * kn周报明细邮件参数封装
 */
@Data
public class KNSalesWeeklyDetail {

    private String channel;

    private Integer channelRowspan;
    private List<SalesSummary> data;
}
