package net.socket.qqDemo.common;

public class ClientTextMessage extends Message {

	public ClientTextMessage(byte[] content) {
		super(content);
		setType(TYPE_CLIENT_TEXT);
	}
}
