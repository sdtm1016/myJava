package net.socket.qqDemo.common;

//客户端请求刷新好友列表消息
public class RequestFriendMessage extends Message {
	public RequestFriendMessage() {
		super(new byte[0]);
		setType(TYPE_CLIENT_REQUEST);
	}

	// 由于client的request消息特殊,在生成报文单独重写
	/*
	 * @Override public byte[] generatePackage() { byte[] bytes = new byte[1];
	 * bytes[0] = (byte) this.getType(); return bytes; }
	 */
}
