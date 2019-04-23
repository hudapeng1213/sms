package com.hdp.maven.control;

import java.lang.reflect.Proxy;

public class ProxyClient {
	public static  <t> t getClient(Class<t> clazz,String ip,int port){
		return (t) Proxy.newProxyInstance(ProxyClient.class.getClassLoader(), new Class[]{clazz}, new ClientHandler(ip,port));
	}
}
