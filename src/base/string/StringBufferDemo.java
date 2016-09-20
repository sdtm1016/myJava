package base.string;

/**
 * String是常量 ,而StringBuffer是一个缓冲区
 */
public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		// StringBuffer 线程安全(内部操作有synchronized同步)
		// 所以性能会低点
		buffer.append("abc");
		buffer.append(new String("def"));

		String str = buffer.toString();
		System.out.println(str);

		// StringBuilder是线程不安全的,但性能快
		StringBuilder builder = new StringBuilder();
		builder.append("abc");
		builder.append(new String("def"));
		str = builder.toString();
		System.out.println(str);
		// test();

		String filename = "E:\\Workspaces\\FileInput\test.txt";
		String txt = filename.substring(filename.lastIndexOf("."));
		System.out.println(txt);

		System.out.println(buffer.length());
		// 通过debug分析capacity中value.length的分配原理
		System.out.println(buffer.capacity());
		buffer.append("higklmnopq").append("rst");
		System.out.println(buffer.capacity());

		StringBuffer bufDelChar = buffer.deleteCharAt(0);
		System.out.println(bufDelChar);

	}

	// 性能测试
	public static void test() {

		StringBuffer buffer = new StringBuffer();
		StringBuilder builder = new StringBuilder();
		long time = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			buffer.append("i");
		}
		System.out.println("1w次append,StringBuffer耗时: "
				+ (System.currentTimeMillis() - time) + "ms");
		time = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			builder.append("i");
		}
		System.out.println("1w次append,StringBuilder耗时: "
				+ (System.currentTimeMillis() - time) + "ms");
	}
}