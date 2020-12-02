package com.entity;

import lombok.Data;

import java.util.List;

@Data
public class KNSalesWeeklyDetailRes {
    private String date;
    private String dateRowspan;
    private List<KNSalesWeeklyDetail> knSalesWeeklyDetail;
}
