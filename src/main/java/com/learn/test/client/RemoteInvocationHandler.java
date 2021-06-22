package com.learn.test.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.learn.test.rpc.RpcRequest;

/**
 * 代理实现类
 *
 * @author Bai
 * @date 2021/6/22 21:03
 */
public class RemoteInvocationHandler implements InvocationHandler {

	private String host;
	private int port;
	public RemoteInvocationHandler (String host, int port) {
		this.host = host;
		this.port = port;
	}


	@Override
	public Object invoke (Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("执行了");
		//构建入参
		RpcRequest rpcRequest = new RpcRequest();
		rpcRequest.setClassName(method.getDeclaringClass().getName());
		rpcRequest.setMethod(method.getName());
		rpcRequest.setArgs(args);
		//发送远程调用消息
		RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);
		return rpcNetTransport.send(rpcRequest);
	}
}
