package com.learn.test.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.learn.test.rpc.RpcRequest;

/**
 * @author Bai
 * @date 2021/6/22 21:11
 */
public class RpcNetTransport {
	private static final int BUFFER_SIZE=1024*1024;

	private String host;
	private int port;

	public RpcNetTransport (String host, int port) {
		this.host = host;
		this.port = port;
	}

	public Object send (RpcRequest request) {
		Socket socket = null;
		Object result = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;

		try {
			//建立连接
			socket = new Socket(host, port);
			//网络socket
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			//序列化()
			outputStream.writeObject(request);
			outputStream.flush();

			inputStream = new ObjectInputStream(socket.getInputStream());
			result = inputStream.readObject();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
