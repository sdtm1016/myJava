package base.extend.messageDemo;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		Message text = new TextMessage("TextMessage");
		Message request = new RequestMessage();
		test(text);
		test(request);
	}

	public static void test(Message message) {
		byte[] bytes = message.generatePackage();

		Message m = MessageFactory.tranformPack(bytes);
		System.out.println("length: " + m.getLength());
		System.out.println("type: " + m.getType());
		System.out.println("content: " + Arrays.toString(m.getContent()));
		System.out.println(Arrays.toString(m.getPack()));

		System.out.println(m.getClass().getName());
		System.out.println(new String(m.getContent()));
	}
}
