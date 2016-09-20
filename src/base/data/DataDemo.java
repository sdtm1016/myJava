package base.data;

public class DataDemo {
	public static void main(String[] args) {
		Integer i1 = new Integer(12);
		Integer i2 = 12;// 自动装箱
		System.out.println(i2);// 自动拆箱
		// 如果包装类中引用数据为null,拆箱会出错
		// Integer i3 = new Integer(null);
		// System.out.println(i3);

		// 关于位运算
		int x = 1;// 0001
		int y = x << 2;// 0100=4
		int z = x << 4;// 1111+1=0001 0000(4bit存储最大值)
		System.out.println("x:" + x + "; y:" + y + "; z:" + z);

		// 基本类型, 有符号则最大位为符号位置,如果为1表示负,0表示正
		byte byteMax = (byte) ((1 << 7) - 1);// 有符号
		System.out.println("byte占8bit:" + byteMax + ";\tByte.MAX_VALUE:" + Byte.MAX_VALUE);

		int charMax = (1 << 16) - 1;// 无符号
		System.out.println("char占2个byte位:" + charMax + ";\tCharacter.MAX_VALUE:" + Character.MAX_VALUE);
		// System.out.println((int) Character.MAX_VALUE);
		int intMax = (1 << 31) - 1;// 有符号
		System.out.println("int占4个byte位:" + intMax + ";\tInteger.MAX_VALUE:" + Integer.MAX_VALUE);

		// 取负数为正值的补码:反码+1(按位取反~后加1)
		// 位运算非(~)
		System.out.println("1的负数是:" + (~1 + 1));

		// 位运算与(&):同时为1时，结果为1，否则为0

		// 或(|):只要有1时，结果为1，否则为0

		// 异或(^):彼此对应位置值不相同时结果为1,相同(同为1或0),结果为0

	}
}
