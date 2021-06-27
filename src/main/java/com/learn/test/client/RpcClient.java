package com.learn.test.client;

import com.learn.test.rpc.RpcTestService;

/**
 * 远程客户端
 *
 * @author Bai
 * @date 2021/6/10 22:52
 */
public class RpcClient {

	public Object rpcInvoker () {
		RpcTestService rpcTestService = (RpcTestService)RpcProxyClient
			.clientProxy(RpcTestService.class, "localhost", 7003);
		final String hello = rpcTestService.hello("我来啦~");
		System.out.println(hello);
		return hello;
	}

}
