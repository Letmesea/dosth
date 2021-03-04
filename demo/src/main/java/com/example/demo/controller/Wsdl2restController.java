package com.example.demo.controller;

import com.example.demo.wsdl.CxfUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用webservice
 */
@Controller
@RequestMapping("/wsdl")
public class Wsdl2restController {
    @RequestMapping(value = "/getWsdl")
    @ResponseBody
    public Map<String,Object> getWsdl(Long redPacketId, Long userId){
        String url = "http://10.18.23.135:8082/ws/helloWebService?wsdl";
        String method = "hello";//方法
        Object[] parameters = new Object[]{"hello"};//入参
        Object res = CxfUtil.invokeRemoteMethod(url, method, parameters)[0];
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("res",res);
        return retMap;
    }
}
