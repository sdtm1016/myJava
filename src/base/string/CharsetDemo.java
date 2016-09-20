package base.string;

import java.io.UnsupportedEncodingException;

public class CharsetDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "a中b国c";

		// iso8859-1没有中文码,中文进行getBytes后,反编译将会是?
		byte[] bytes = str.getBytes("iso8859-1");
		System.out.println(bytes.length);
		System.out.println(new String(bytes, "iso8859-1"));

		// gbk有中文码,是gb2312增强版
		bytes = str.getBytes("gbk");
		System.out.println(bytes.length);
		System.out.println(new String(bytes, "gbk"));

		// gb2312
		bytes = str.getBytes("gb2312");
		System.out.println(bytes.length);
		System.out.println(new String(bytes, "gb2312"));

		// utf-8,三个字节表示一个汉字(中/韩/日/朝文),英文2个字节,可以debug分析
		bytes = str.getBytes("utf-8");
		System.out.println(bytes.length);
		System.out.println(new String(bytes, "utf-8"));

		// catUTF8();
		// Unicode自动转换
		char c = '\u0061';
		System.out.println(c);
		System.out.println("\u4f60\u597d!a\u4e2db\u56fdc");
		unicodeTest();
	}

	public static void catUTF8() {
		// 查看utf-8对应的字符
		int n = 0;
		for (int i = 0x0011; i < 0xffff;) {
			if (n == 100) {
				System.out.println();
				n = 0;
			}
			System.out.print((char) i);
			i = i + 50;
			n++;
		}

	}

	public static void unicodeTest() throws UnsupportedEncodingException {
		char[] chars = { '\u0061' };
		String str = new String(chars);
		byte[] bytes = str.getBytes("unicode");
		for (int i = 0; i < bytes.length; i++) {
			System.out.print(bytes[i] + " ");
		}
	}

}