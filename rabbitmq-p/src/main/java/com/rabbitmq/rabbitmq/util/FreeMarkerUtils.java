package com.rabbitmq.rabbitmq.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
        list.removeAll(Collections.singletonList("3"));
        List<Integer> list1= list.stream().filter(it->it>3).map(it->it).collect(Collectors.toList());

        Map<String, Object> map = new HashMap<>();

//        String stringmap =FileUtil.readFile("D:\\prj\\coding\\dosth\\rabbitmq-p\\src\\main\\resources\\datakn");
//        JSONObject jsonObject = JSONObject.parseObject(stringmap);
//        map.put("date",jsonObject.getJSONObject("map").get("date"));
//        map.put("salesDataDetail",jsonObject.getJSONObject("map").get("salesDataDetail"));
//        map.put("salesData",jsonObject.getJSONObject("map").get("salesData"));


        String url = FreeMarkerUtils.class.getResource("/").getPath()+"/datadaily";
        String string = FileUtil.readFile(url);
        JSONObject jsonObject1 = JSONObject.parseObject(string);
        map.put("date",jsonObject1.getJSONObject("map").get("date"));
        map.put("salesData",jsonObject1.getJSONObject("map").get("salesData"));
        map.put("salesDataChannel",jsonObject1.getJSONObject("map").get("salesDataChannel"));
        map.put("salesDataProduct",jsonObject1.getJSONObject("map").get("salesDataProduct"));
        map.put("salesDataPccode",jsonObject1.getJSONObject("map").get("salesDataPccode"));
        String res = getTemplate("salesDailyt.ftl",map);
        String path = FreeMarkerUtils.class.getResource("/").getPath()+"/13.html";
        FileUtil.writeFile(path,res);
//        System.out.println(res);
    }


/*   合并去重 在java8出现以后，我们有了更方便高效的做法，就是通过Stream来帮我们完成这项操作，代码如下：

    List<String> collect = Stream.of(listA, listB)
            .flatMap(Collection::stream)
            .distinct()
            .collect(Collectors.toList());*/

}
