
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.example.demo.client;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-03-03T15:55:53.803+08:00
 * Generated source version: 3.4.2
 *
 */

@WebService(
                      serviceName = "HelloWebService",
                      portName = "HelloWebServiceImplPort",
                      targetNamespace = "xb.ceair.com",
                      wsdlLocation = "http://10.18.23.135:8082/ws/helloWebService?wsdl",
                      endpointInterface = "com.example.demo.client.HelloWebService")

public class HelloWebServiceImplPortImpl implements HelloWebService {

    private static final Logger LOG = Logger.getLogger(HelloWebServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.example.demo.client.HelloWebService#hello(java.lang.String name)*
     */
    public String hello(String name) {
        LOG.info("Executing operation hello");
        System.out.println(name);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
