package net.socket.qqDemo.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Set;

import base.data.util.ByteArrayUtil;
import net.socket.qqDemo.common.Message;
import net.socket.qqDemo.utils.SocketUtil;

/**
 * Controller层,接收消息
 */
public class ReceiverThread extends Thread {
	// socket
	private Socket socket;
	// 输入流读取服务器转发的信息
	private InputStream is;
	private GUI ui;

	public ReceiverThread(Socket sock, GUI window) {
		try {
			this.socket = sock;
			is = sock.getInputStream();
			this.ui = window;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getSock() {
		return socket;
	}

	@Override
	public void run() {
		while (true) {
			// baseProcessMessage();
			try {
				processMessage();//循环阻塞
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	private void processMessage() throws IOException {
		//int type = is.read();
		int type = SocketUtil.readMessageType(is);
		int len = SocketUtil.readMessageLen(is);
		byte[] bytes = SocketUtil.readMessage(is, len);
		if (type == Message.TYPE_SERVER_RSPONDS) {// 列表对象
			Set<String> friends = SocketUtil.readFriends(bytes);// 反序列化
			ui.refreshFriendsUI(friends);
		} else if (type == Message.TYPE_SERVER_TEXT) {
			String chatText = SocketUtil.readText(bytes);// 转化为字符串
			ui.appendChatArea(chatText);
		}
	}

	public void baseProcessMessage() {
		try {
			// 读取type
			int type = is.read();
			// 读取length
			byte[] buf = new byte[4];
			is.read(buf);
			int len = ByteArrayUtil.byteArray2Int(buf);
			// 读取内容
			byte[] bytes = new byte[len];
			is.read(bytes);

			if (type == Message.TYPE_SERVER_RSPONDS) {// 列表对象
				Set<String> friends = SocketUtil.readFriends(bytes);// 反序列化
				ui.refreshFriendsUI(friends);
			} else if (type == Message.TYPE_SERVER_TEXT) {
				String chatText = new String(bytes);// 转化为字符串
				ui.appendChatArea(chatText);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
