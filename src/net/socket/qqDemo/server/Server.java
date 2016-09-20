package net.socket.qqDemo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.socket.qqDemo.common.ServerFriendsMessage;
import net.socket.qqDemo.utils.SocketUtil;

//单例类
public class Server {
	public static Set<String> friends = new HashSet<String>();
	public static List<Socket> allSocket = new ArrayList<Socket>();

	@SuppressWarnings("resource")
	public void start(int port) {
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Server start...");
			Socket sock;
			while (true) {
				sock = ss.accept();// sock对象与并发的client对应
				System.out.println("Conection Client");

				friends.add(SocketUtil.getAddr(sock));
				allSocket.add(sock);
				MassagePushThread.pushALL(new ServerFriendsMessage(friends));
				
				// 根据socket启动对应线程单独处理接收消息
				new Thread(new MessageResponseThread(sock)).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
