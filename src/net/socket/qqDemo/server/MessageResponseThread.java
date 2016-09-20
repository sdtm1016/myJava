package net.socket.qqDemo.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import net.socket.qqDemo.common.ClientTextMessage;
import net.socket.qqDemo.common.Message;
import net.socket.qqDemo.common.RequestFriendMessage;
import net.socket.qqDemo.common.ServerFriendsMessage;
import net.socket.qqDemo.common.ServerTextMessage;
import net.socket.qqDemo.utils.SocketUtil;

public class MessageResponseThread implements Runnable {
	private Socket sock;
	private InputStream is;

	// 一个线程对应一个客户端的socket
	public MessageResponseThread(Socket sock) {
		this.sock = sock;
		try {
			this.is = sock.getInputStream();
			// 解析message
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			Message receive = MessageFactory.parseClientPack(is);
			if (receive == null) {
				return;
			}
			Class<? extends Message> clazz = receive.getClass();
			Message response = null;
			if (clazz == ClientTextMessage.class) {// 群发
			//	System.out.println(Arrays.toString(receive.getContent()));
				response = new ServerTextMessage(receive.getContent());
				MassagePushThread.pushALL(response);
			} else if (clazz == RequestFriendMessage.class) {// 单发返回
				response = new ServerFriendsMessage(Server.friends);
				MassagePushThread.push(sock, response);
			}
		}
	}

	// 转换报文
	public Message tranformPack(InputStream is) {
		Message message = null;
		try {
			int type = is.read();
			int length = 0;
			byte[] text = null;
			switch (type) {
			case Message.TYPE_CLIENT_TEXT:
				length = SocketUtil.readMessageLen(is);// 读取4个字节
				text = SocketUtil.readMessage(is, length);// 读取length个字节
				message = new ServerTextMessage(text);
				MassagePushThread.pushALL(message);// 群发
				break;
			case Message.TYPE_CLIENT_REQUEST:
				message = new ServerFriendsMessage(Server.friends);
				MassagePushThread.push(sock, message);// 单发返回
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

}
