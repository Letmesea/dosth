package com.rabbitmq.rabbitmq.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.entity.KNSalesWeeklyDetailRes;
import com.entity.SalesSummary;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH,-7);
        String begin = simpleDateFormat.format(c.getTime());
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH,-1);
        String end = simpleDateFormat.format(c.getTime());
        Map<String, Object> map = new HashMap<>();
        String detail = "[{\"date\":\"2020-11-25\",\"dateRowspan\":\"2\",\"knSalesWeeklyDetail\":[{\"channel\":\"OTA携程\",\"channelRowspan\":1,\"data\":[{\"channel\":\"OTA携程\",\"productType\":\"KN互售\",\"salesAmount\":\"1678\",\"passengerTp\":\"ADT\",\"pmj\":\"1628\",\"fee\":\"50\",\"orderSum\":\"1\",\"tktSum\":\"1\",\"segSum\":\"1\",\"date\":\"2020-11-25\"}]},{\"channel\":\"全球版APP\",\"channelRowspan\":1,\"data\":[{\"channel\":\"全球版APP\",\"productType\":\"KN互售\",\"salesAmount\":\"6078\",\"passengerTp\":\"ADT\",\"pmj\":\"6028\",\"fee\":\"50\",\"orderSum\":\"2\",\"tktSum\":\"2\",\"segSum\":\"1\",\"date\":\"2020-11-25\"}]}]},{\"date\":\"2020-11-26\",\"dateRowspan\":\"3\",\"knSalesWeeklyDetail\":[{\"channel\":\"OTA携程\",\"channelRowspan\":1,\"data\":[{\"channel\":\"OTA携程\",\"productType\":\"KN互售\",\"salesAmount\":\"1678\",\"passengerTp\":\"ADT\",\"pmj\":\"1628\",\"fee\":\"50\",\"orderSum\":\"1\",\"tktSum\":\"1\",\"segSum\":\"1\",\"date\":\"2020-11-26\"}]},{\"channel\":\"全球版APP\",\"channelRowspan\":1,\"data\":[{\"channel\":\"全球版APP\",\"productType\":\"KN互售\",\"salesAmount\":\"3308\",\"passengerTp\":\"ADT\",\"pmj\":\"3258\",\"fee\":\"50\",\"orderSum\":\"2\",\"tktSum\":\"2\",\"segSum\":\"1\",\"date\":\"2020-11-26\"}]},{\"channel\":\"国内PC简体中文\",\"channelRowspan\":1,\"data\":[{\"channel\":\"国内PC简体中文\",\"productType\":\"KN互售\",\"salesAmount\":\"3308\",\"passengerTp\":\"ADT\",\"pmj\":\"3258\",\"fee\":\"50\",\"orderSum\":\"1\",\"tktSum\":\"1\",\"segSum\":\"1\",\"date\":\"2020-11-26\"}]}]},{\"date\":\"2020-11-27\",\"dateRowspan\":\"1\",\"knSalesWeeklyDetail\":[{\"channel\":\"国内PC简体中文\",\"channelRowspan\":1,\"data\":[{\"channel\":\"国内PC简体中文\",\"productType\":\"KN互售\",\"salesAmount\":\"0\",\"passengerTp\":\"ADT\",\"pmj\":\"0\",\"fee\":\"0\",\"orderSum\":\"1\",\"tktSum\":\"1\",\"segSum\":\"0\",\"date\":\"2020-11-27\"}]}]},{\"date\":\"2020-12-01\",\"dateRowspan\":\"1\",\"knSalesWeeklyDetail\":[{\"channel\":\"OTA携程\",\"channelRowspan\":1,\"data\":[{\"channel\":\"OTA携程\",\"productType\":\"KN互售\",\"salesAmount\":\"3356\",\"passengerTp\":\"ADT\",\"pmj\":\"3256\",\"fee\":\"100\",\"orderSum\":\"2\",\"tktSum\":\"2\",\"segSum\":\"2\",\"date\":\"2020-12-01\"}]}]}]";
        String summ = "[{\"channel\":\"全球版APP\",\"productType\":\"KN互售\",\"salesAmount\":\"9386\",\"pmj\":\"9286\",\"fee\":\"100\",\"orderSum\":\"4\",\"tktSum\":\"4\",\"segSum\":\"2\"},{\"channel\":\"OTA携程\",\"productType\":\"KN互售\",\"salesAmount\":\"6712\",\"pmj\":\"6512\",\"fee\":\"200\",\"orderSum\":\"4\",\"tktSum\":\"4\",\"segSum\":\"4\"},{\"channel\":\"国内PC简体中文\",\"productType\":\"KN互售\",\"salesAmount\":\"3308\",\"pmj\":\"3258\",\"fee\":\"50\",\"orderSum\":\"2\",\"tktSum\":\"1\",\"segSum\":\"1\"}]";
        map.put("date",begin+"~"+end);
        List<SalesSummary> salesSummaries = JSONArray.parseArray(summ,SalesSummary.class);
        List<KNSalesWeeklyDetailRes> salesDetail=JSONArray.parseArray(detail,KNSalesWeeklyDetailRes.class);
        map.put("salesData",salesSummaries);
        map.put("salesDataDetail",salesDetail);
        String res = getTemplate("kn.ftl",map);
        System.out.println(res);
    }
}
