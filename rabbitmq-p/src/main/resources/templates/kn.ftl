<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>KN互售${date}报表</title>
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
    <!--周数据-->
    <div class="div1_1 div1_11">KN互售${date}报表</div>
</div>
<div class="div1">
    <!--周数据-->
    <div class="div1_1">汇总</div>
</div>
<table id="t1_4" class="orderPrintTable"
       style="margin-bottom: 10px; border-collapse:collapse; font-size: 13px; vertical-align: middle; text-align: center; border:1px solid #c2c2c2; color: #1a2c4c;"
       width="100%" cellpadding="6" border="1">
    <tbody>
    <tr style="color: #ffffff;
height: 24px; line-height: 24px;" bgcolor="#1a2c4c">
        <th id="t1_4_r01" style="font-weight: normal; text-align: center;" scope="col" width="10%">渠道
        </th>
        <th id="t1_4_r02" style="font-weight: normal; text-align: center;" scope="col" width="10%">产品类型
        </th>
        <th id="t1_4_r03" style="font-weight: normal; text-align: center;" scope="col" width="10%">销售金额
        </th>
        <th id="t1_4_r04" style="font-weight: normal; text-align: center;" scope="col" width="10%">票面价
        </th>
        <th id="t1_4_r05" style="font-weight: normal; text-align: center;" scope="col" width="10%">税费
        </th>
        <th id="t1_4_r06" style="font-weight: normal; text-align: center;" scope="col" width="10%">订单数
        </th>
        <th id="t1_4_r07" style="font-weight: normal; text-align: center;" scope="col" width="10%">票数
        </th>
        <th id="t1_4_r08" style="font-weight: normal; text-align: center;" scope="col" width="10%">航段数
        </th>
    </tr>
    <#list salesData as sdata>
    <tr>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${sdata.channel}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${sdata.productType}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${sdata.salesAmount}
            </div>
        </td>
        <td style="text-align: center;">
            <div>
                <span id="t1_4_r09">${sdata.pmj}</span>
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${sdata.fee}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${sdata.orderSum}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${sdata.tktSum}
            </div>
        </td>
        <td>
            <div style="white-space: nowrap;
text-align: center;">${sdata.segSum}
            </div>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
<div class="div1">
    <!--明细-->
    <div class="div1_1">明细</div>
</div>
<table id="t1_2" class="orderPrintTable" style="margin: 0; border-collapse: collapse;
font-size: 13px; vertical-align: middle; text-align: center; border: 1px solid
#c2c2c2; padding: 6px" scope="col" width="100%" cellpadding="6" border="1">
    <tbody>

    <tr style="color: #ffffff;
height: 24px; line-height: 24px;" bgcolor="#1a2c4c">
        <th id="t1_2_r01" style="font-weight: normal; text-align: center;  padding: 6px" scope="col" width="8%">日期
        </th>
        <th id="t1_2_r02" style="font-weight: normal; text-align: center;  padding: 6px" scope="col" width="8%">渠道
        </th>
        <th id="t1_2_r03" style="font-weight: normal; text-align: center;  padding: 6px" scope="col" width="8%">用户类型
        </th>
        <th id="t1_4_r04" style="font-weight: normal; text-align: center;" scope="col" width="8%">产品类型
        </th>
        <th id="t1_4_r05" style="font-weight: normal; text-align: center;" scope="col" width="8%">销售金额
        </th>
        <th id="t1_4_r06" style="font-weight: normal; text-align: center;" scope="col" width="8%">票面价
        </th>
        <th id="t1_4_r07" style="font-weight: normal; text-align: center;" scope="col" width="8%">税费
        </th>
        <th id="t1_4_r08" style="font-weight: normal; text-align: center;" scope="col" width="8%">订单数
        </th>
        <th id="t1_4_r09" style="font-weight: normal; text-align: center;" scope="col" width="8%">票数
        </th>
        <th id="t1_4_r10" style="font-weight: normal; text-align: center;" scope="col" width="8%">航段数
        </th>
    </tr>
    <#list salesDataDetail as sdd>
    <tr style="border-bottom: 1px solid #c2c2c2">
        <td rowspan="${sdd.dateRowspan?number+1}" style="text-align:center; ">${sdd.date}
        </td>
    </tr>
    <#list sdd.knSalesWeeklyDetail as sdd1>
        <#list sdd1.data as sdd11>
            <tr>
                <#if sdd11_index==0>
                    <td rowspan="${sdd1.channelRowspan}" style="text-align: center; ">
                        <span id="t1_2_r09">${sdd11.channel}</span>
                    </td>
                </#if>
                <td style="text-align: center; ">
                    <span id="t1_2_r09">${sdd11.passengerTp}</span>
                </td>
                <td  style="text-align: center; ">
                    <span id="t1_2_r09">${sdd11.productType}</span>
                </td>
                <td  style="text-align: center; ">
                    <span id="t1_2_r09">${sdd11.salesAmount}</span>
                </td>
                <td  style="text-align: center; ">
                    <span id="t1_2_r09">${sdd11.pmj}</span>
                </td>
                <td  style="text-align: center; ">
                    <span id="t1_2_r09">${sdd11.fee}</span>
                </td>
                <td  style="text-align: center; ">
                    <span id="t1_2_r09">${sdd11.orderSum}</span>
                </td>
                <td  style="text-align: center; ">
                    <span id="t1_2_r09">${sdd11.tktSum}</span>
                </td>
                <td  style="text-align: center; ">
                    <span id="t1_2_r09">${sdd11.segSum}</span>
                </td>
            </tr>
            </#list>
        </#list>
    </#list>
    </tbody>
</table>
</body>
</html>