package net.socket.qqDemo.common;

import base.data.util.ByteArrayUtil;

//将各种消息封装为对象
public class Message {

	// 客户端输入文本
	public static final int TYPE_CLIENT_TEXT = 1;
	// 客户端请求刷新好友列表
	public static final int TYPE_SERVER_TEXT = 2;
	// 服务器刷新聊天内容
	public static final int TYPE_SERVER_RSPONDS = 3;
	// 服务器刷新好友列表
	public static final int TYPE_CLIENT_REQUEST = 4;
	private int type;// 0,1
	protected int length;
	private byte[] content;

	private byte[] pack;

	public Message(byte[] content) {
		setContent(content);
	}

	// 生成整个报文,包含信息+消息本身
	public byte[] generatePackage() {
		pack = new byte[5 + this.getLength()];
		pack[0] = (byte) this.getType();// pack[0]
		byte[] bytes = ByteArrayUtil.int2ByteArray(this.getLength());
		System.arraycopy(bytes, 0, pack, 1, 4);// pack[1,2,3,4]
		System.arraycopy(content, 0, pack, 5, content.length);
		return pack;
	}

	public byte[] getPack() {
		if (null != this.pack) {
			return pack;
		}
		return generatePackage();
	}
	public void setContent(byte[] text) {
		this.content = text;
		this.length = text.length;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public byte[] getContent() {
		return content;
	}

}
