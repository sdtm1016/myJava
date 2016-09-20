package base.extend.messageDemo;

import base.data.util.ByteArrayUtil;

//将各种消息封装为对象
public class Message {

	public static final int TEXT = 0;
	public static final int REQUEST = 4;
	private int type;// 0,1
	private int length;
	private byte[] content;
	private byte[] pack;

	// 生成整个报文,包含信息+消息本身
	public byte[] generatePackage() {
		pack = new byte[5 + this.getLength()];
		pack[0] = (byte) this.getType();// pack[0]
		byte[] bytes = ByteArrayUtil.int2ByteArray(this.getLength());
		System.arraycopy(bytes, 0, pack, 1, 4);// pack[1,2,3,4]
		
		System.arraycopy(this.getContent(), 0, pack, 5, this.getContent().length);
		return pack;
	}

	public byte[] getPack() {
		return pack;
	}

	public void setPack(byte[] pack) {
		this.pack = pack;
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

	public void setContent(byte[] text) {
		this.content = text;
		this.length = text.length;
	}

}
