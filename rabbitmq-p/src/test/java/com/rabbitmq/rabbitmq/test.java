package com.rabbitmq.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.rabbitmq.dto.B;
import com.utils.EncryptUtil;

/**
 * @author Letmesea
 * @title: test
 * @projectName dosth
 * @description: TODO
 * @date 2020/6/216:08
 */
public class test {
    public static void main(String[] args) throws Exception {

        String A1 = "{\"channel\":\"zhengtao\",\"refundAmount\":\"18\"}";
        B b = JSONObject.parseObject(A1,B.class);
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
