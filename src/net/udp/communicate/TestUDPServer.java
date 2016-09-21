package net.udp.communicate;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 数据报套接字服务端
 *
 */
public class TestUDPServer {
	public static void main(String[] args) throws IOException {
		System.out.println("--------------server端------------");
		byte[] buff = new byte[1024];
		// 创建一个数据包,用来服务端接收到的数据
		DatagramPacket dp = new DatagramPacket(buff, 0, buff.length);
		// 创建一个绑定本机9999端口的数据报套接字
		DatagramSocket ds = new DatagramSocket(9999);
		while (true) {
			// 阻塞式的接收一个数据包
			ds.receive(dp);
			System.out.println(new String(buff, 0, buff.length));
		}
	}
}