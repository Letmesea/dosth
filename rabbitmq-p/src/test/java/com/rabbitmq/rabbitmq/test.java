package com.rabbitmq.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.rabbitmq.dto.A;
import com.rabbitmq.rabbitmq.dto.B;
import com.utils.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Letmesea
 * @title: test
 * @projectName dosth
 * @description: TODO
 * @date 2020/6/216:08
 */
public class test extends A {
     void gf(){
        logger.error("234");
    }
    public static void main(String[] args) throws Exception {

        String strTmp = new String("BBBB,YBBYYYYYYY");
        strTmp = strTmp.replaceAll ("\\D", "Y");
        System.out.println(strTmp);
        strTmp = strTmp.replaceAll ("Y", "N");
        System.out.println(strTmp);
        strTmp = strTmp.replace("N", "C");
        System.out.println(strTmp);
        strTmp = strTmp.replaceFirst("\\D", "q");
        System.out.println(strTmp);

         List<A> listA = new ArrayList<>();
         listA.add(new A("1","1.0"));
         listA.add(new A("2","2.0"));
         for (A a:listA){
             a.setIt(1);
         }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd hh:mm:ss");

        Date date = sdf.parse("2021-04-10 12:34:45");//null/""无法转换
        Date date1 = sdf1.parse("2021-04-10 12:34:45");//null/""无法转换


        long hour = 60 * 60 * 1000L;
        String flina ;
        String[] slist =new String[10];
        List<String> l1 =  Arrays.asList(slist);
        List<String> testGroup = Arrays.asList("1","1","2",null);
        Map<String,List<String>> stringListMap1 = testGroup.stream()
                .filter(Objects::nonNull).
        collect(Collectors.groupingBy(String::intern));
        List<String> join = null;
        String q1 = String.join(",", Objects.requireNonNull(join));
        String A1 = "{\"channel\":\"zhengtao\",\"payAmount\":\"18\",\"as\":[],\"it\":1}";
        B b = JSONObject.parseObject(A1,B.class);
        List<String> list = new ArrayList<>();
        String res = String.join("",list);

        String a1 ="{\"pageSize\":0,\"pageIndex\":0,\"largeCustomerName\":\"ç´«å\n" +
        "éå\"}";
        String ss = new String(a1.getBytes("ISO8859-1"), "UTF-8");
        long a = System.currentTimeMillis();
//        Thread.sleep(3000);
        for(long i=0;i<30000000L;i++){
            i++;
        }
        System.out.println(System.currentTimeMillis()-a);
    }
}
