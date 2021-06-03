package com.example.demo.controller;

import com.example.demo.service.impl.WebService;
import com.example.demo.wsdl.CxfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 调用webservice
 */
@Controller
@RequestMapping("/wsdl")
public class Wsdl2restController {
    /**
     * wsdl测试调用
     */
    @Autowired
    WebService webService;
    @GetMapping(value = "/getWsdl")
    @ResponseBody
    public Map<String,Object> getWsdl(Long redPacketId, Long userId){
        String method = "hello";//方法
        Object[] parameters = new Object[]{"hello"};//入参
        return webService.wsdl2Rest(parameters,method);
    }

}
