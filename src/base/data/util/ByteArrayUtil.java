package base.data.util;

public class ByteArrayUtil {

	// int to byte
	public static byte[] int2ByteArray(int i) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) i;
		bytes[1] = (byte) (i >> 8);
		bytes[2] = (byte) (i >> 16);
		bytes[3] = (byte) (i >> 24);
		return bytes;
	}

	// byte to int
	public static int byteArray2Int(byte[] arr) {
		int i3 = arr[3] << 24;// arr[3]转换为int高8位的byte数据,并用i3记录
		// arr[2]转换为int的第16-24的byte数据
		int i2 = (arr[2] & 0xFF) << 16;// 这里先将arr[2]通过& 0xFF运算,删除arr[3]的数据,然后位移
		int i1 = (arr[1] & 0xFF) << 8;// 同上
		int i0 = arr[0] & 0xFF;

		return i3 | i2 | i1 | i0;// 最后按位或运算得到byte[4]对应的int
	}

	/**
	 * @param src
	 *            要转换为int的字节数组
	 * @param srcPos
	 *            指定该字节数组的位置
	 * @return 返回字节数组src从srcPos到srcPos+4转换得到的int值
	 */
	public static int byteArray2Int(byte[] src, int srcPos) {
		int i3 = src[3 + srcPos] << 24;
		int i2 = (src[2 + srcPos] & 0xFF) << 16;
		int i1 = (src[1 + srcPos] & 0xFF) << 8;
		int i0 = src[0 + srcPos] & 0xFF;
		return i3 | i2 | i1 | i0;
	}

	/**
	 * 
	 * @param src
	 *            要截取的原字节数组
	 * @param srcPos
	 *            原字节数组src开始截取的位置
	 * @param length
	 *            对字节数组src截取的长度
	 * @return 返回截取的数组
	 */
	public static byte[] getBytes(byte[] src, int srcPos, int length) {
		byte[] dest = new byte[length];
		System.arraycopy(src, srcPos, dest, 0, length);
		return dest;
	}

	/**
	 * 
	 * @param src
	 *            原字节数组
	 * @param srcPos
	 *            从该字节数组的位置srcPos开始转换
	 * @param length
	 *            获取指定数组长度进行转换
	 * @return 返回转换数组指定位置和长度的字符串
	 */
	public static String byteArray2String(byte[] src, int srcPos, int length) {

		byte[] buff = new byte[src.length - srcPos];
		System.arraycopy(src, srcPos, buff, 0, length);
		return new String(buff);

	}

	// long转换为8个byte(64bit)
	public static byte[] long2ByteArray(long l) {
		byte[] bytes = new byte[8];
		for (int i = 0; i < 8; i++) {
			bytes[i] = (byte) (l >> (i * 8));
		}
		return bytes;
	}

	public static long byteArray2Long(byte[] bytes) {
		// 0xff为16进制中表示每个位全为1的byte值:1111 1111;
		long l = 0;
		for (int i = 0; i < 8; i++) {
			l = l | ((long) bytes[i] & 0xff) << (i * 8);
		}
		return l;
	}
}
