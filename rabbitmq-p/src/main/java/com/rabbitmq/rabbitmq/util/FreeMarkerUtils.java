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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> map = new HashMap<>();
        String detail = "[{\"date\":\"2020-11-19\",\"dateRowspan\":\"2\",\"knSalesWeeklyDetail\":[{\"channel\":\"7690\",\"channelRowspan\":2,\"data\":[{\"channel\":\"7690\",\"productType\":\"KN互售\",\"salesAmount\":\"7186\",\"passengerTp\":\"ADT\",\"pmj\":\"6836\",\"fee\":\"350\",\"orderSum\":\"10\",\"tktSum\":\"9\",\"segSum\":\"7\",\"date\":\"2020-11-19\"},{\"channel\":\"7690\",\"productType\":\"KN互售\",\"salesAmount\":\"810\",\"passengerTp\":\"CHD\",\"pmj\":\"810\",\"fee\":\"0\",\"orderSum\":\"3\",\"tktSum\":\"2\",\"segSum\":\"1\",\"date\":\"2020-11-19\"}]}]},{\"date\":\"2020-11-20\",\"dateRowspan\":\"2\",\"knSalesWeeklyDetail\":[{\"channel\":\"7301\",\"channelRowspan\":1,\"data\":[{\"channel\":\"7301\",\"productType\":\"KN互售\",\"salesAmount\":\"1678\",\"passengerTp\":\"ADT\",\"pmj\":\"1628\",\"fee\":\"50\",\"orderSum\":\"1\",\"tktSum\":\"1\",\"segSum\":\"1\",\"date\":\"2020-11-20\"}]},{\"channel\":\"7690\",\"channelRowspan\":1,\"data\":[{\"channel\":\"7690\",\"productType\":\"KN互售\",\"salesAmount\":\"1678\",\"passengerTp\":\"ADT\",\"pmj\":\"1628\",\"fee\":\"50\",\"orderSum\":\"1\",\"tktSum\":\"1\",\"segSum\":\"1\",\"date\":\"2020-11-20\"}]}]},{\"date\":\"2020-11-23\",\"dateRowspan\":\"1\",\"knSalesWeeklyDetail\":[{\"channel\":\"7301\",\"channelRowspan\":1,\"data\":[{\"channel\":\"7301\",\"productType\":\"KN互售\",\"salesAmount\":\"10068\",\"passengerTp\":\"ADT\",\"pmj\":\"9768\",\"fee\":\"300\",\"orderSum\":\"4\",\"tktSum\":\"4\",\"segSum\":\"4\",\"date\":\"2020-11-23\"}]}]},{\"date\":\"2020-11-24\",\"dateRowspan\":\"2\",\"knSalesWeeklyDetail\":[{\"channel\":\"7301\",\"channelRowspan\":2,\"data\":[{\"channel\":\"7301\",\"productType\":\"KN互售\",\"salesAmount\":\"16780\",\"passengerTp\":\"ADT\",\"pmj\":\"16280\",\"fee\":\"500\",\"orderSum\":\"5\",\"tktSum\":\"7\",\"segSum\":\"7\",\"date\":\"2020-11-24\"},{\"channel\":\"7301\",\"productType\":\"KN互售\",\"salesAmount\":\"8910\",\"passengerTp\":\"CHD\",\"pmj\":\"8910\",\"fee\":\"0\",\"orderSum\":\"3\",\"tktSum\":\"8\",\"segSum\":\"8\",\"date\":\"2020-11-24\"}]}]},{\"date\":\"2020-11-25\",\"dateRowspan\":\"2\",\"knSalesWeeklyDetail\":[{\"channel\":\"7860\",\"channelRowspan\":1,\"data\":[{\"channel\":\"7860\",\"productType\":\"KN互售\",\"salesAmount\":\"6078\",\"passengerTp\":\"ADT\",\"pmj\":\"6028\",\"fee\":\"50\",\"orderSum\":\"2\",\"tktSum\":\"2\",\"segSum\":\"1\",\"date\":\"2020-11-25\"}]},{\"channel\":\"7301\",\"channelRowspan\":1,\"data\":[{\"channel\":\"7301\",\"productType\":\"KN互售\",\"salesAmount\":\"1678\",\"passengerTp\":\"ADT\",\"pmj\":\"1628\",\"fee\":\"50\",\"orderSum\":\"1\",\"tktSum\":\"1\",\"segSum\":\"1\",\"date\":\"2020-11-25\"}]}]}]";
        String summ = "[{\"channel\":\"7860\",\"productType\":\"KN互售\",\"salesAmount\":\"6078\",\"pmj\":\"6028\",\"fee\":\"50\",\"orderSum\":\"2\",\"tktSum\":\"2\",\"segSum\":\"1\"},{\"channel\":\"7301\",\"productType\":\"KN互售\",\"salesAmount\":\"39114\",\"pmj\":\"38214\",\"fee\":\"900\",\"orderSum\":\"11\",\"tktSum\":\"21\",\"segSum\":\"21\"},{\"channel\":\"7690\",\"productType\":\"KN互售\",\"salesAmount\":\"9674\",\"pmj\":\"9274\",\"fee\":\"400\",\"orderSum\":\"11\",\"tktSum\":\"12\",\"segSum\":\"9\"}]";
        map.put("date","2020-11-19~2020-11-25");
        List<SalesSummary> salesSummaries = JSONArray.parseArray(summ,SalesSummary.class);
        List<KNSalesWeeklyDetailRes> salesDetail=JSONArray.parseArray(detail,KNSalesWeeklyDetailRes.class);
        map.put("salesData",salesSummaries);
        map.put("salesDataDetail",salesDetail);
        String res = getTemplate("kn.ftl",map);
        System.out.println(res);
    }
}
