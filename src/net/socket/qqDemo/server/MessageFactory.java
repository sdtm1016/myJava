package net.socket.qqDemo.server;

import java.io.IOException;
import java.io.InputStream;

import net.socket.qqDemo.common.ClientTextMessage;
import net.socket.qqDemo.common.Message;
import net.socket.qqDemo.common.RequestFriendMessage;
import net.socket.qqDemo.utils.SocketUtil;

//服务端的消息工厂,客户端接收到消息后直接反序列化处理
public class MessageFactory {

	// 根据输入流,截取报文,并按类型转换为对象
	public static Message parseClientPack(InputStream is) {
		Message message = null;
		try {
			int type = is.read();
			int length = SocketUtil.readMessageLen(is);
			byte[] text = SocketUtil.readMessage(is, length);
			switch (type) {
			case Message.TYPE_CLIENT_REQUEST:
				message = new RequestFriendMessage();
				break;
			case Message.TYPE_CLIENT_TEXT:
				message = new ClientTextMessage(text);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}
}
