package base.extend.messageDemo;


import base.data.util.ByteArrayUtil;

//消息工厂
public class MessageFactory {

	public static Message tranformPack(byte[] bytes) {
		Message message = null;
		int type = bytes[0];
		int length = 0;
		switch (type) {
		case Message.TEXT:
			length = ByteArrayUtil.byteArray2Int(bytes, 1);
			String text = new String(ByteArrayUtil.byteArray2String(bytes, 5, length));
			message = new TextMessage(text);
			break;
		case Message.REQUEST:
			message = new RequestMessage();
			break;
		}
		return message;
	}
}
