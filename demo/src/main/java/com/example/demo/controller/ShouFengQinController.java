package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.wsdl.CxfUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 手风琴接口
 */
@Controller
@RequestMapping("/sfq")
public class ShouFengQinController {
    /**
     * 页面
     * @return
     */
    @GetMapping("/sfq")
    public String test(){
        return "shoufengqin";
    }
    /**
     * 获取数据接口
     * @return
     */
    @PostMapping(value = "/getData")
    @ResponseBody
    public Map<String,Object> getData(){
        List<Map<String ,String >> list = new ArrayList<>();
        for (int i=0;i<4;i++){
            Map<String ,String > map = new HashMap<>();
            map.put("id",i+"");
            map.put("title","标题");
            map.put("content","111111111111111");
            list.add(map);
        }

        Map<String,Object> retMap = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","0");
        jsonObject.put("msg","success");
        jsonObject.put("data",list);
        retMap.put("res",jsonObject);
        return retMap;
    }


}
