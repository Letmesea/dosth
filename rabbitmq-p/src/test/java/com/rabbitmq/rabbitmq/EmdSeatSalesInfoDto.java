package com.rabbitmq.rabbitmq;




import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class EmdSeatSalesInfoDto {

	/**
	 * 币种
	 */
	private String salechannel;
	
	/**
	 * 选座订单号
	 */
	private String tradingorderno;
	
	/**
	 * 销售价
	 */
	private String realcarrcd;

	/**
	 * 实付价
	 */
	private String emdOrderNo;

	private String scny;
	
	private String pointAmount;

	private String paysuccessno;
	
	/**
	 * 积分
	 */
	private String iata;

	/**
	 * 国家
	 * @return
	 */
	private String flighttktno;
	/**
	 * 语言
	 * @return
	 */
	private String tktTktNo;
	/**
	 * 销售渠道
	 */
	private String iataNo;
	/**
	 * 支付渠道
	 */
	private String paychannel;
	/**
	 * 大订单号
	 */
	private String pccode;
	/**
	 * emd票号
	 */
	private String createDtm;
	/**
	 * 机票客票号
	 */
	private String tktDate;


	/**
	 * 支付银行
	 */
	private String paysuccessdate;

	/**
	 * 银行订单号
	 */
	private String settlementtype;
	/**
	 *
	 */

	private String orderNo;

}
