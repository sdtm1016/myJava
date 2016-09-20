package base.string;


import java.nio.charset.Charset;

public class StrDemo {

	public static void main(String[] args) throws Exception {
		String str1 = "abc";
		String str2 = new String("abc");

		// equals 和 ==
		System.out.println("str1.equals(str2): " + str1.equals(str2));
		System.out.println("str1==str2: " + (str1 == str2));

		// charAt,length
		System.out.println("str1.charAt(1): " + str1.charAt(1));
		for (int i = 0; i < str1.length(); i++) {
			System.out.println("str[" + i + "] = " + str1.charAt(i));
		}

		// getBytes
		byte[] bytes = str1.getBytes();
		System.out.println("str1.getBytes().length: " + bytes.length);

		// toCharArray()
		char[] arr = str1.toCharArray();
		System.out.println("str1.toCharArray(): " + arr);

		// indexOf()
		int index = str1.indexOf("b");
		System.out.println("str1.indexOf(\"b\"): " + index);

		// startsWith / endWith
		boolean b = str1.startsWith("ab");
		System.out.println("str1.startsWith(\"ab\"): " + b);
		System.out.println("str1.startsWith(\"Ab\"): " + str1.startsWith("Ab"));

		// toUpperCase / toLowerCase
		System.out.println("str1.toUpperCase(): " + str1.toUpperCase());
		System.out.println("str1.toLowerCase(): " + str1.toLowerCase());

		// 练习
		System.out.println(reverseStr(null));
		System.out.println(reverseStr(""));
		System.out.println(reverseStr("a"));
		System.out.println(reverseStr("abcdefg"));

		// split
		str1 = "abc,1990,12,22";
		String[] strArr = str1.split(",");
		if (strArr != null && strArr.length > 0)
			for (int i = 0; i < strArr.length; i++) {
				System.out.println(strArr[i]);
			}

		// subString(index)范围左包右不包即:区间[str)
		String subString = str1.substring(0, str1.length());
		System.out.println("str1.substring(0,str1.length()): " + subString);
		// 练习
		// mySubStr(null, 0, 1);
		// mySubStr("abcd", -1, 0);
		mySubStr("abcd", 0, 0);
		mySubStr("abcd", 0, 4);
		// mySubStr("abcd", 0, 5);

		// 编码问题
		"中国".getBytes();
		System.out.println(Charset.defaultCharset().name());
	}

	// 面试试题 字符串反转
	public static String reverseStr(String str) {
		// str == null要先于str.length()判断,以及length为0和1都不需要反转(考察点)
		if (str == null || str.length() < 2) {
			return str;
		}
		String tmp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			tmp = tmp + str.charAt(i);
		}
		return tmp;
	}

	public static String mySubStr(String srcStr, int beginIndex, int length) throws Exception {
		// src != null
		if (srcStr == null) {
			throw new Exception("源串为null");
		}
		// beginIndex从0开始,最大为str.length()-1
		if (beginIndex < 0 || beginIndex > srcStr.length()) {
			throw new Exception("起始索引非法!");
		}
		// length从0开始,beginIndex+length最大为str.length
		if (length < 0 || length > srcStr.length() || length + beginIndex > srcStr.length()) {
			throw new Exception("选择长度非法!");
		}
		return srcStr.substring(beginIndex, beginIndex + length);
	}
}