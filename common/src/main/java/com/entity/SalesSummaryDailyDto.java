package com.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 自销日报模板对象
 */
@Data
public class SalesSummaryDailyDto {
    private String channel;
    private String productType;
    //订单数
    private Integer orderSum;
    //票面额
    private BigDecimal pmj;
    //税费（包含ob）
    private BigDecimal tax;
    //总销量，机票销售的现金总金额（不含积分抵扣，卡券抵扣金额；包含改期手续费）
    private BigDecimal salesAmt;
    //积分支付销量（纯积分支付的积分）
    private BigDecimal pointAmt;
    //混合支付的积分额
    private BigDecimal dynamicPointAmt;
    //现金支付票量
    private Integer cashTktSum;
    //积分支付客票量
    private Integer pointTktSum;
    //混合支付票量
    private Integer dynamicPointTktSum;
    private Integer segSum;
    //订单取消量
    private Integer orderCancelSum;
    //积分抵扣
    private BigDecimal point2Cash;
    //卡券抵扣
    private BigDecimal pricePromoAmount;
    //国内销量总额
    private BigDecimal domesticSalesAmt;
    //国际销量总额
    private BigDecimal interSalesAmt;
    //总票量
    private Integer tktSum;
    //总退票量
    private Integer refundTktSum;
    //总退票订单数
    private Integer refundOrderSum;
    //总退票金额
    private BigDecimal refundAmt;
    //改期升舱的客票量
    private Integer ugOrChangeTktSum;
    //改期升舱的订单量
    private Integer ugOrChangeOrderSum;
    //改期升舱的销售总额
    private BigDecimal ugOrChangeSalesAmt;


}
