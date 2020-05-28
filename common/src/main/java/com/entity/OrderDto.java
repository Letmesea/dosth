package com.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Letmesea
 * @title: OrderDto
 * @projectName dosth
 * @description: TODO
 * @date 2020/5/2813:02
 */
@Data
public class OrderDto {
    /**
     * 订单编号
     */
    private String id;

    /**
     * 商户编号
     */
    private String merchantId;

    /**
     * 订单金额
     */
    private BigDecimal amount;

    /**
     * 交易时间
     */
    private String tradeTime;
}
