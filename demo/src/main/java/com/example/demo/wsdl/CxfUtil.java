package com.example.demo.wsdl;

import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;


/**
 * webservice 调用工具类
 * */
public class CxfUtil {
	public static <T> T getService(String address, Class<T> clazz) {
		// 代理工厂
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		// 设置代理地址
		jaxWsProxyFactoryBean.setAddress(address);
		// 设置接口类型
		jaxWsProxyFactoryBean.setServiceClass(clazz);
		// 创建一个代理接口实现
		@SuppressWarnings("unchecked")
		T cs = (T) jaxWsProxyFactoryBean.create();
		return cs;
	}


	public static void main(String[] args) throws Exception {
		String url = "http://10.18.23.135:8082/ws/helloWebService?wsdl";
		String method = "hello";
		Object[] parameters = new Object[]{"我是参数"};
		System.out.println(invokeRemoteMethod(url, method, parameters)[0]);
	}

	public static Object[] invokeRemoteMethod(String url, String operation, Object[] parameters){
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		if (!url.endsWith("wsdl")) {
			url += "?wsdl";
		}
		org.apache.cxf.endpoint.Client client = dcf.createClient(url);
		//处理webService接口和实现类namespace不同的情况，CXF动态客户端在处理此问题时，会报No operation was found with the name的异常
		Endpoint endpoint = client.getEndpoint();
		QName opName = new QName(endpoint.getService().getName().getNamespaceURI(),operation);
		BindingInfo bindingInfo= endpoint.getEndpointInfo().getBinding();
		if(bindingInfo.getOperation(opName) == null){
			for(BindingOperationInfo operationInfo : bindingInfo.getOperations()){
				if(operation.equals(operationInfo.getName().getLocalPart())){
					opName = operationInfo.getName();
					break;
				}
			}
		}
		Object[] res = null;
		try {
			res = client.invoke(opName, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
