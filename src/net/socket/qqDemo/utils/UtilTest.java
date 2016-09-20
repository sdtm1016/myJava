package net.socket.qqDemo.utils;

import java.io.IOException;
import java.io.InputStream;

public class UtilTest {
	public static void main(String[] args) {
		System.out.println(SocketUtil.getHostName());
	}

	public static void test() {

		try {
			// 单例模式,降低耦合度(解耦合)
			Runtime rt = Runtime.getRuntime();
			Process process = rt.exec("hostname");
			InputStream is = process.getInputStream();
			SocketUtil.readString(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
