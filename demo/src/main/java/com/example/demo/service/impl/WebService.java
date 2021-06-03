package com.example.demo.service.impl;

import com.example.demo.wsdl.CxfUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebService {
    //wsdl接口
   private static final String URL = "http://10.18.23.135:8082/ws/helloWebService?wsdl";

    /**
     * 调用wsdl接口
     * @param parameters
     * @return
     */
   public Map<String,Object> wsdl2Rest(Object[] parameters,String method){
       Object res = CxfUtil.invokeRemoteMethod(URL, method, parameters)[0];
       Map<String,Object> retMap = new HashMap<>();
       retMap.put("res",res);
       return retMap;
   }
}
