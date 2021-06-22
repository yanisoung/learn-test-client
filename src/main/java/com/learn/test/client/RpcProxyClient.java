package com.learn.test.client;

import java.lang.reflect.Proxy;

/**
 * 远程代理类
 *
 * @author Bai
 * @date 2021/6/22 20:56
 */
public class RpcProxyClient {

	public Object clientProxy (Class<?> interfaces, String host, int port) {
		RemoteInvocationHandler remoteInvocationHandler = new RemoteInvocationHandler(host, port);
		return Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[] {interfaces}, remoteInvocationHandler);
	}
}
