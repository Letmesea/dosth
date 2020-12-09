package com.rabbitmq.rabbitmq.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.entity.KNSalesWeeklyDetailRes;
import com.entity.SalesSummary;
import com.entity.SalesSummaryDailyDto;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FreeMarkerUtils {
    public static String getTemplate(String template, Map<String,Object> map) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        String templatePath = FreeMarkerUtils.class.getResource("/").getPath()+"/templates";
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        Template temp = cfg.getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        temp.process(map, stringWriter);
        return stringWriter.toString();
    }
    public static void  main(String[] args) throws IOException, TemplateException {
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(4);
        List<Integer> list1= list.stream().filter(it->it>3).map(it->it).collect(Collectors.toList());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH,-1);
        String end = simpleDateFormat.format(c.getTime());
        Map<String, Object> map = new HashMap<>();
        String prd = "[{\"productType\":\"MULTI_NEW\",\"orderSum\":1,\"pmj\":2330.00,\"tax\":100.00,\"salesAmt\":2430.00,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":1,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":1},{\"productType\":\"COMMON_W\",\"orderSum\":1,\"pmj\":3200.00,\"tax\":240.00,\"salesAmt\":3440.00,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":1,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":1},{\"productType\":\"MUBRAND_Y\",\"orderSum\":1,\"pmj\":920.00,\"tax\":140.00,\"salesAmt\":1060.00,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":1,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":1},{\"productType\":\"COMMON_INTER_Y\",\"orderSum\":11,\"pmj\":269290.17,\"tax\":23405.91,\"salesAmt\":292696.08,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":13,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":13},{\"productType\":\"COMMON_Y\",\"orderSum\":39,\"pmj\":60467.66,\"tax\":2560.26,\"salesAmt\":63027.92,\"pointAmt\":0,\"dynamicPointAmt\":400,\"cashTktSum\":50,\"pointTktSum\":0,\"dynamicPointTktSum\":1,\"segSum\":51},{\"productType\":\"UM\",\"orderSum\":1,\"pmj\":1640.00,\"tax\":0.00,\"salesAmt\":1640.00,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":1,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":1},{\"productType\":\"OTHER_KN\",\"orderSum\":1,\"pmj\":488.00,\"tax\":50.00,\"salesAmt\":538.00,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":1,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":1},{\"productType\":\"ZMWXF2020\",\"orderSum\":2,\"pmj\":1850.00,\"tax\":50.00,\"salesAmt\":1900.00,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":2,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":1}]";
        String chn="[{\"channel\":\"APP\",\"orderSum\":10,\"pmj\":10730.00,\"tax\":740.00,\"salesAmt\":11470.00,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":12,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":11},{\"channel\":\"海外PC\",\"orderSum\":5,\"pmj\":41847.83,\"tax\":4280.17,\"salesAmt\":46128.00,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":6,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":6},{\"channel\":\"PC\",\"orderSum\":37,\"pmj\":274508.00,\"tax\":21126.00,\"salesAmt\":295634.00,\"pointAmt\":0,\"dynamicPointAmt\":400,\"cashTktSum\":44,\"pointTktSum\":0,\"dynamicPointTktSum\":1,\"segSum\":45},{\"channel\":\"M站\",\"orderSum\":5,\"pmj\":13100.00,\"tax\":400.00,\"salesAmt\":13500.00,\"pointAmt\":0,\"dynamicPointAmt\":0,\"cashTktSum\":8,\"pointTktSum\":0,\"dynamicPointTktSum\":0,\"segSum\":8}]";
        String summ = "{\"orderSum\":57,\"pmj\":340185.83,\"tax\":26546.17,\"salesAmt\":366732.00,\"pointAmt\":0,\"dynamicPointAmt\":400,\"pointTktSum\":0,\"dynamicPointTktSum\":1,\"orderCancelSum\":58,\"point2Cash\":10.00,\"pricePromoAmount\":490.00,\"domesticSalesAmt\":106795.92,\"interSalesAmt\":259936.08,\"tktSum\":71,\"refundTktSum\":57,\"refundOrderSum\":41,\"refundAmt\":181227.94,\"ugOrChangeTktSum\":3,\"ugOrChangeOrderSum\":3,\"ugOrChangeSalesAmt\":8170.00}";
        map.put("date",end);
        SalesSummaryDailyDto salesSummaries = JSON.parseObject(summ, SalesSummaryDailyDto.class);
        List<SalesSummaryDailyDto> salesChn=JSONArray.parseArray(chn,SalesSummaryDailyDto.class);
        List<SalesSummaryDailyDto> salesPrd=JSONArray.parseArray(prd,SalesSummaryDailyDto.class);
        map.put("salesData",salesSummaries);
        map.put("salesDataChannel",salesChn);
        map.put("salesDataProduct",salesPrd);

        String res = getTemplate("salesDailyt.ftl",map);
        String path = "D:\\prj\\coding\\dosth\\rabbitmq-p\\src\\main\\resources\\12.html";
        FileUtil.writeFile(path,res);
        System.out.println(res);
    }
}
