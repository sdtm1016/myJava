package base.extend.messageDemo;

public class RequestMessage extends Message {
	public RequestMessage() {
		this.setType(REQUEST);
		this.setContent(new byte[0]);
		this.setPack(generatePackage());
	}

	// 由于client的request消息特殊,在生成报文单独重写
	@Override
	public byte[] generatePackage() {
		byte[] bytes = new byte[1];
		bytes[0] = (byte) this.getType();
		return bytes;
	}
}
