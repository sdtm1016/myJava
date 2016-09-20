package base.data.util;

public class ByteArrayUtilTest {
	public static void main(String[] args) {
		//testInt();
		testLong();
	}

	public static void testInt() {
		int i = 345;
		byte[] bytes = ByteArrayUtil.int2ByteArray(i);
		int i2 = ByteArrayUtil.byteArray2Int(bytes);
		System.out.println(i2);
	}

	public static void testLong() {
		long time = System.currentTimeMillis();
		System.out.println(time);
		byte[] bytes = ByteArrayUtil.long2ByteArray(time);
		System.out.println(ByteArrayUtil.byteArray2Long(bytes));
	}
}
