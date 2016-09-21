package net.udp.communicate;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 数据报套接字客户端
 *
 */
public class TestUDPClient {
	public static void main(String[] args) throws IOException {
		System.out.println("--------------client端------------");
		byte[] buff = "Hello Server!".getBytes();
		// 创建一个数据包，其中指定了发送的目标地
		DatagramPacket dp = new DatagramPacket(buff, 0, buff.length, new InetSocketAddress("192.168.1.101", 9999));
		// 创建一个数据报套接字,绑定到随机可用的端口上
		DatagramSocket ds = new DatagramSocket();
		// 通过该数据包套接向目标发送数据
		ds.send(dp);
		// 关闭套接字
		ds.close();
	}
}