package com.learn.test;

import com.learn.test.client.RpcClient;
import com.learn.test.client.RpcProxyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Bai
 * @date 2021/6/10 22:51
 */
//开启AspectJ的Proxy设置，使得SpringBoot容器可以解析aop配置
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = "com.learn.test")
@PropertySource(value = {"classpath:application.properties"})
public class Application {

	public static void main (String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("------------启动成功-----------");
	}
}
