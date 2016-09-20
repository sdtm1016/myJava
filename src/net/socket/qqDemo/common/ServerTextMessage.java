package net.socket.qqDemo.common;

public class ServerTextMessage extends Message {

	// 直接通过原生报文构造消息对象
	public ServerTextMessage(byte[] text) {
		super(text);
		setType(TYPE_SERVER_TEXT);
	}
}
