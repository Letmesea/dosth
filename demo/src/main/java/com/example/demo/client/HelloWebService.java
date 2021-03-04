package com.example.demo.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-03-03T15:55:53.810+08:00
 * Generated source version: 3.4.2
 *
 */
@WebService(targetNamespace = "http://service.xb.ceair.com/", name = "HelloWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWebService {

    @WebMethod
    @RequestWrapper(localName = "hello", targetNamespace = "http://service.xb.ceair.com/", className = "com.example.demo.client.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://service.xb.ceair.com/", className = "com.example.demo.client.HelloResponse")
    @WebResult(name = "return", targetNamespace = "")
    public String hello(

        @WebParam(name = "name", targetNamespace = "")
        String name
    );
}
