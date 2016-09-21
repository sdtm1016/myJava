/**
 * 
 */
/**
 * @author Noah
 *
 */
package net.udp.communicate.twoway;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 数据报套接字服务端：接收发送消息
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
			// 打印接收的数据
			System.out.println("[" + dp.getAddress().getHostAddress() + ":" + dp.getPort() + "]" + "的消息："
					+ new String(buff, 0, buff.length));
			String msg = "[" + dp.getAddress().getHostAddress() + ":" + dp.getPort() + "]" + "服务端已经收到你的数据包了！";
			// 响应客户端，回复一个消息，当然这个端口地址需要从接收到的数据包中获取
			DatagramPacket dps = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, dp.getSocketAddress());
			ds.send(dps);
		}
	}
}