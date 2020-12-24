package com.rabbitmq.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.rabbitmq.dto.A;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TestCompleteFuture {
    public static void main(String[] args) throws ParseException {

        List<DateParam> listD = new ArrayList<>();
        List<String> list = getDays("2020-09-01 00:00:00","2020-09-30 23:59:59");
        if(list.size()>25){
            DateParam dateParam = new DateParam();
            dateParam.setStart(list.get(0));
            dateParam.setEnd(list.get(list.size()/2)+" 23:59:59");
            listD.add(dateParam);
            DateParam dateParam1 = new DateParam();
            dateParam1.setStart(list.get(list.size()/2+1));
            dateParam1.setEnd(list.get(list.size()-1)+" 23:59:59");
            listD.add(dateParam1);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//注意月份是MM
        Date date = simpleDateFormat.parse("2020-09-01 00:00:00");
        Date date1 =  simpleDateFormat.parse("2020-09-30 23:59:59");

        int a = differentDaysByMillisecond(date,date1);
        long start = System.currentTimeMillis();
        issueTicketManual();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void issueTicketManual(){
        Map<String,Object> map = new HashMap<>();
        List<A> list = new ArrayList<>();
        list.add(new A("111","1"));
        list.add(new A("222","2"));
        list.add(new A("333","3"));
        /*注意在这里定义的变量，如果要在lambda表达式中赋值，会出现问题*/
//        A a = new A();
        List<CompletableFuture<List<String>>> messageFutures = list
                .stream()
                .map(flight -> CompletableFuture.supplyAsync(() -> {
                    try {
                        A a = new A();
                        a.setChannel(flight.getChannel());
                        return func(a);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return new ArrayList<String>();
                }))
                .collect(Collectors.toList());
        //线程等待，获取结果
        List<List<String>> results = messageFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(JSONObject.toJSON(results).toString());
        map.put("result", results);
    }
    public static List<String> func(A s) throws InterruptedException {
        Thread.sleep(10);
        return Arrays.asList(s.getChannel());
    }
    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
    public static List<String> getDays(String startTime, String endTime) {

        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }
}
