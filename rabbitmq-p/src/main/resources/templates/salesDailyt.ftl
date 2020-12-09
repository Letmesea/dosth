<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>自销日报${date}</title>
    <style>
        .div1 {
            display: flex;
            align-items: center;
            justify-content: left;
        }
        .div2 {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .div1_1 {
            padding: 0 5px;
            font-size: 15px;
            background: no-repeat left bottom;
            padding-bottom: 5px;
            padding-top: 10px;
            font-weight: bold
        }
        .div1_11{
            font-size: 20px;
        }
        td{
            border: 1px solid;
        }
        th{
            border: 1px solid;
        }
    </style>
</head>
<body>
<div class="div2">
    <div class="div1_1 div1_11">自销日报${date}</div>
</div>
<div class="div1">
    <div class="div1_1">销量汇总</div>
</div>
<table id="t1_4" class="orderPrintTable"
       style="margin-bottom: 10px; border-collapse:collapse; font-size: 13px; vertical-align: middle; text-align: center; border:1px solid #c2c2c2; color: #1a2c4c;"
       width="100%" cellpadding="6" border="1">
    <tbody>
    <tr style="color: #ffffff;
height: 24px; line-height: 24px;" bgcolor="#1a2c4c">
        <th id="t1_4_r01" style="font-weight: normal; text-align: center;" scope="col" width="10%">总订单数
        </th>
        <th id="t1_4_r02" style="font-weight: normal; text-align: center;" scope="col" width="10%">票面额（现金）
        </th>
        <th id="t1_4_r03" style="font-weight: normal; text-align: center;" scope="col" width="10%">税费
        </th>
        <th id="t1_4_r04" style="font-weight: normal; text-align: center;" scope="col" width="10%">总销量（现金）
        </th>
        <th id="t1_4_r05" style="font-weight: normal; text-align: center;" scope="col" width="10%">积分抵扣金额
        </th>
        <th id="t1_4_r06" style="font-weight: normal; text-align: center;" scope="col" width="10%">卡券抵扣金额
        </th>
        <th id="t1_4_r07" style="font-weight: normal; text-align: center;" scope="col" width="10%">积分支付销量
        </th>
        <th id="t1_4_r08" style="font-weight: normal; text-align: center;" scope="col" width="10%">动态积分支付销量
        </th>
        <th id="t1_4_r08" style="font-weight: normal; text-align: center;" scope="col" width="10%">国际销量（现金）
        </th>
        <th id="t1_4_r08" style="font-weight: normal; text-align: center;" scope="col" width="10%">国内销量（现金）
        </th>
    </tr>
    <tr>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.orderSum}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.pmj}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.tax}
            </div>
        </td>
        <td style="text-align: center;">
            <div>
                <span id="t1_4_r09">${salesData.salesAmt}</span>
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.point2Cash}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.pricePromoAmount}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.pointAmt}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.dynamicPointAmt}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.interSalesAmt}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.domesticSalesAmt}
            </div>
        </td>
    </tr>
    </tbody>
</table>
<table id="t1_4" class="orderPrintTable"
       style="margin-bottom: 10px; border-collapse:collapse; font-size: 13px; vertical-align: middle; text-align: center; border:1px solid #c2c2c2; color: #1a2c4c;"
       width="50%" cellpadding="6" border="1">
    <tbody>
    <tr style="color: #ffffff;
height: 24px; line-height: 24px;" bgcolor="#1a2c4c">
        <th id="t1_4_r01" style="font-weight: normal; text-align: center;" scope="col" width="10%">总机票量
        </th>
        <th id="t1_4_r02" style="font-weight: normal; text-align: center;" scope="col" width="10%">积分支付机票量
        </th>
        <th id="t1_4_r03" style="font-weight: normal; text-align: center;" scope="col" width="10%">动态积分支付机票量
        </th>
    </tr>
    <tr>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.tktSum}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.pointTktSum}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.dynamicPointTktSum}
            </div>
        </td>
    </tr>
    </tbody>
</table>
<table id="t1_4" class="orderPrintTable"
       style="margin-bottom: 10px; border-collapse:collapse; font-size: 13px; vertical-align: middle; text-align: center; border:1px solid #c2c2c2; color: #1a2c4c;"
       width="50%" cellpadding="6" border="1">
    <tbody>
    <tr style="color: #ffffff;
height: 24px; line-height: 24px;" bgcolor="#1a2c4c">
        <th id="t1_4_r01" style="font-weight: normal; text-align: center;" scope="col" width="10%">总退票量
        </th>
        <th id="t1_4_r02" style="font-weight: normal; text-align: center;" scope="col" width="10%">总退票订单数
        </th>
        <th id="t1_4_r03" style="font-weight: normal; text-align: center;" scope="col" width="10%">总退票金额
        </th>
        <th id="t1_4_r03" style="font-weight: normal; text-align: center;" scope="col" width="10%">订单取消量
        </th>
    </tr>
    <tr>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.refundTktSum}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.refundOrderSum}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.refundAmt}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.orderCancelSum}
            </div>
        </td>
    </tr>
    </tbody>
</table>
<table id="t1_4" class="orderPrintTable"
       style="margin-bottom: 10px; border-collapse:collapse; font-size: 13px; vertical-align: middle; text-align: center; border:1px solid #c2c2c2; color: #1a2c4c;"
       width="50%" cellpadding="6" border="1">
    <tbody>
    <tr style="color: #ffffff;
height: 24px; line-height: 24px;" bgcolor="#1a2c4c">
        <th id="t1_4_r01" style="font-weight: normal; text-align: center;" scope="col" width="10%">总换开票数
        </th>
        <th id="t1_4_r02" style="font-weight: normal; text-align: center;" scope="col" width="10%">总换开订单数
        </th>
        <th id="t1_4_r03" style="font-weight: normal; text-align: center;" scope="col" width="10%">总换开金额（现金）
        </th>
    </tr>
    <tr>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.ugOrChangeTktSum}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.ugOrChangeOrderSum}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${salesData.ugOrChangeSalesAmt}
            </div>
        </td>
    </tr>
    </tbody>
</table>

<div class="div1">
    <!--明细-->
    <div class="div1_1">渠道销售明细</div>
</div>
<table id="t1_2" class="orderPrintTable" style="margin: 0; border-collapse: collapse;
font-size: 13px; vertical-align: middle; text-align: center; border: 1px solid
#c2c2c2; padding: 6px" scope="col" width="100%" cellpadding="6" border="1">
    <tbody>
    <tr style="color: #ffffff;
height: 24px; line-height: 24px;" bgcolor="#1a2c4c">
        <th id="t1_2_r01" style="font-weight: normal; text-align: center;  padding: 6px" scope="col" width="8%">子渠道
        </th>
        <th id="t1_2_r02" style="font-weight: normal; text-align: center;  padding: 6px" scope="col" width="8%">订单数
        </th>
        <th id="t1_2_r03" style="font-weight: normal; text-align: center;  padding: 6px" scope="col" width="8%">票面额
        </th>
        <th id="t1_4_r04" style="font-weight: normal; text-align: center;" scope="col" width="8%">税费
        </th>
        <th id="t1_4_r05" style="font-weight: normal; text-align: center;" scope="col" width="8%">销售金额
        </th>
        <th id="t1_4_r06" style="font-weight: normal; text-align: center;" scope="col" width="8%">积分支付金额
        </th>
        <th id="t1_4_r07" style="font-weight: normal; text-align: center;" scope="col" width="8%">动态积分支付金额
        </th>
        <th id="t1_4_r08" style="font-weight: normal; text-align: center;" scope="col" width="8%">现金支付客票量
        </th>
        <th id="t1_4_r09" style="font-weight: normal; text-align: center;" scope="col" width="8%">积分支付客票量
        </th>
        <th id="t1_4_r10" style="font-weight: normal; text-align: center;" scope="col" width="8%">动态积分支付客票量
        </th>
        <th id="t1_4_r10" style="font-weight: normal; text-align: center;" scope="col" width="8%">航段数
        </th>
    </tr>
    <#list salesDataChannel as sdd11>
    <tr>
        <td style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.channel}</span>
        </td>
        <td style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.orderSum}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.pmj}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.tax}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.salesAmt}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.pointAmt}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.dynamicPointAmt}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.cashTktSum}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.pointTktSum}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.dynamicPointTktSum}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.segSum}</span>
        </td>
    </tr>
    </#list>
    </tbody>
</table>

<div class="div1">
    <!--明细-->
    <div class="div1_1">产品销售明细</div>
</div>
<table id="t1_2" class="orderPrintTable" style="margin: 0; border-collapse: collapse;
font-size: 13px; vertical-align: middle; text-align: center; border: 1px solid
#c2c2c2; padding: 6px" scope="col" width="100%" cellpadding="6" border="1">
    <tbody>
    <tr style="color: #ffffff;
height: 24px; line-height: 24px;" bgcolor="#1a2c4c">
        <th id="t1_2_r01" style="font-weight: normal; text-align: center;  padding: 6px" scope="col" width="8%">按照产品类型统计
        </th>
        <th id="t1_2_r02" style="font-weight: normal; text-align: center;  padding: 6px" scope="col" width="8%">订单数
        </th>
        <th id="t1_2_r03" style="font-weight: normal; text-align: center;  padding: 6px" scope="col" width="8%">票面额
        </th>
        <th id="t1_4_r04" style="font-weight: normal; text-align: center;" scope="col" width="8%">税费
        </th>
        <th id="t1_4_r05" style="font-weight: normal; text-align: center;" scope="col" width="8%">销售金额
        </th>
        <th id="t1_4_r06" style="font-weight: normal; text-align: center;" scope="col" width="8%">积分支付金额
        </th>
        <th id="t1_4_r07" style="font-weight: normal; text-align: center;" scope="col" width="8%">动态积分支付金额
        </th>
        <th id="t1_4_r08" style="font-weight: normal; text-align: center;" scope="col" width="8%">现金支付客票量
        </th>
        <th id="t1_4_r09" style="font-weight: normal; text-align: center;" scope="col" width="8%">积分支付客票量
        </th>
        <th id="t1_4_r10" style="font-weight: normal; text-align: center;" scope="col" width="8%">动态积分支付客票量
        </th>
        <th id="t1_4_r10" style="font-weight: normal; text-align: center;" scope="col" width="8%">航段数
        </th>
    </tr>
    <#list salesDataProduct as sdd11>
    <tr>
        <td style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.productType}</span>
        </td>
        <td style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.orderSum}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.pmj}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.tax}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.salesAmt}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.pointAmt}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.dynamicPointAmt}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.cashTktSum}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.pointTktSum}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.dynamicPointTktSum}</span>
        </td>
        <td  style="text-align: center; ">
            <span id="t1_2_r09">${sdd11.segSum}</span>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
<p style="margin-bottom: 2%"></p>
</body>
</html>