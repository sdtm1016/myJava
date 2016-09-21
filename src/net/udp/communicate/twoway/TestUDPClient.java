package net.udp.communicate.twoway;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 数据报套接字客户端；发送接收消息
 *
 */
public class TestUDPClient {
	public static void main(String[] args) throws IOException {
		System.out.println("--------------client端------------");
		byte[] buff = "Hello Server!".getBytes();
		// 创建一个数据包，其中指定了发送的目标地
		DatagramPacket dp = new DatagramPacket(buff, 0, buff.length, new InetSocketAddress("192.168.14.117", 9999));
		// 创建一个数据报套接字,绑定到随机可用的端口上
		DatagramSocket ds = new DatagramSocket();
		// 通过该数据包套接向目标发送数据
		ds.send(dp);

		byte[] buffres = new byte[1024];
		// 创建一个用来接收服务器反馈的数据包
		DatagramPacket dbres = new DatagramPacket(buffres, 0, buffres.length, ds.getLocalAddress(), ds.getLocalPort());
		// 接收数据
		ds.receive(dbres);
		// 打印接收的数据
		System.out.println(new String(buffres, 0, buffres.length));
		// 关闭套接字
		ds.close();
	}
}