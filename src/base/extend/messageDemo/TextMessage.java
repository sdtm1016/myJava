package base.extend.messageDemo;

public class TextMessage extends Message {

	public TextMessage(String text) {
		byte[] content = text.getBytes();
		this.setType(TEXT);
		this.setContent(content);
		this.setPack(generatePackage());
	}
}
