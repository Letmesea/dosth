package com.rabbitmq.rabbitmq;

import com.alibaba.fastjson.JSONArray;
import com.rabbitmq.rabbitmq.dto.Person;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TestGroupBy {

    public static void main(String[] args){
        t14();


        String aa = "123--f";
        aa= aa.replaceAll("-"," ");
        Date d = new Date();
        d.setHours(24);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        d = calendar.getTime();

//        String path = TestGroupBy.class.getClassLoader().getResource("untitled.json").getPath();
        String str = readJsonFile("D:\\prj\\coding\\dosth\\rabbitmq-p\\src\\test\\java\\com\\rabbitmq\\rabbitmq\\untitled.json");
        List<EmdSeatSalesInfoDto> emdSeatSalesInfoDtos = JSONArray.parseArray(str,EmdSeatSalesInfoDto.class);
        Map<String, List<EmdSeatSalesInfoDto>> collect = emdSeatSalesInfoDtos.stream().collect(Collectors.groupingBy(e -> fetchGroupKey(e)));
        List<EmdSeatSalesInfoDto> emdSeatSalesInfoDtos1 = new ArrayList<>();
        for(List<EmdSeatSalesInfoDto> list: collect.values()){
            emdSeatSalesInfoDtos1.add(list.get(0));
        }
        Collections.sort(emdSeatSalesInfoDtos1, new Comparator<EmdSeatSalesInfoDto>() {
            @Override
            public int compare(EmdSeatSalesInfoDto o1, EmdSeatSalesInfoDto o2) {
                return Integer.compare(0, o2.getTktDate().compareTo(o1.getTktDate()));
            }
        });
        System.out.println(111);
    }
    private static String fetchGroupKey(EmdSeatSalesInfoDto user){
        StringBuilder sb = new StringBuilder();
        sb.append(user.getRealcarrcd()).append("#")
                .append(user.getCreateDtm()).append("#")
                .append(user.getEmdOrderNo()).append("#")
                .append(user.getFlighttktno()).append("#")
                .append(user.getIata()).append("#")
                .append(user.getIataNo()).append("#")
                .append(user.getPaychannel()).append("#")
                .append(user.getPaysuccessdate()).append("#")
                .append(user.getOrderNo()).append("#")
                .append(user.getPaysuccessno()).append("#")
                .append(user.getPccode()).append("#")
                .append(user.getPointAmount()).append("#")
                .append(user.getSalechannel()).append("#")
                .append(user.getScny()).append("#")
                .append(user.getSettlementtype()).append("#")
                .append(user.getTktDate()).append("#")
                .append(user.getTktTktNo()).append("#")
                .append(user.getTradingorderno());
        return sb.toString();
    }
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void t14() {
        List<Person> roster = Arrays.asList(
                new Person("as", "Test@",12,"F"),
                new Person("zx", "Test@",12,"M"),
                new Person("zc", "Test@",12,"F"),
                new Person("zv", "Test@",12,"M"),
                new Person("zb", "Test@",12,"F"),
                new Person("zn", "Test@",12,"M"),
                new Person("zm", "Test@",12,"F")
        );
        //分组求和
        Map<String, Integer> totalAgeByGender =
                roster.stream()
                        .collect(
                                Collectors.groupingBy(Person::getSex,
                                        Collectors.reducing(0,Person::getAge,Integer::sum)
                                )
                        );
        totalAgeByGender.forEach((k,v) -> System.out.println(k + " : " + v));
    }
}
