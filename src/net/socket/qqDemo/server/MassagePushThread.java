package net.socket.qqDemo.server;

import java.io.IOException;
import java.net.Socket;

import net.socket.qqDemo.common.Message;
import net.socket.qqDemo.utils.SocketUtil;

public class MassagePushThread {

	// 对每个收到的Mesage都进行群发
	public static void pushALL(final Message message) {

		for (final Socket sock : Server.allSocket) {
			new Thread() {
				public void run() {
					try {
						SocketUtil.writeMessage(sock.getOutputStream(), message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();// 并发发送
		}
	}

	public static void push(Socket sock, final Message message) {
		try {
			SocketUtil.writeMessage(sock.getOutputStream(), message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
