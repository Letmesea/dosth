
package com.example.demo.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-03-03T15:55:53.785+08:00
 * Generated source version: 3.4.2
 *
 */
public final class HelloWebService_HelloWebServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("xb.ceair.com", "HelloWebService");

    private HelloWebService_HelloWebServiceImplPort_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = HelloWebService_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        HelloWebService_Service ss = new HelloWebService_Service(wsdlURL, SERVICE_NAME);
        HelloWebService port = ss.getHelloWebServiceImplPort();

        {
        System.out.println("Invoking hello...");
        String _hello_name = "";
        String _hello__return = port.hello(_hello_name);
        System.out.println("hello.result=" + _hello__return);


        }

        System.exit(0);
    }

}
