package com.rabbitmq.rabbitmq.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream api 常用操作
 */
public class StreamUtil {

    /**
     * 合并去重
     * @param a
     * @param b
     * @return
     */
    public static List<Integer> unionDistinct (List<Integer> a,List<Integer> b){
        return Stream.of(a, b)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }



    public static void main(String[] args){
        List<Integer> res = unionDistinct(Arrays.asList(1,2),Arrays.asList(2,3));
        System.out.println(JSON.toJSON(res).toString());
    }
}
