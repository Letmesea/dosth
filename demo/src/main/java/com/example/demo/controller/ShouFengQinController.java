package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.wsdl.CxfUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 手风琴接口
 */
@Controller
@RequestMapping("/sfq")
public class ShouFengQinController {
    @GetMapping(value = "/getData")
    @ResponseBody
    public Map<String,Object> getData(Long redPacketId, Long userId){
        String data = "[{\"id\":\"1\",\"title\":\"标题\",\"内容\":\"内容\"}]";
        Map<String,Object> retMap = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","0");
        jsonObject.put("msg","success");
        jsonObject.put("data",data);
        retMap.put("res",jsonObject);
        return retMap;
    }
}
