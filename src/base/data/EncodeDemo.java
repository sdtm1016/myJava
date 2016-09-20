package base.data;

public class EncodeDemo {

	public static void main(String[] args) throws Exception {
		String s = "中国ABC";
		byte[] byte1 = s.getBytes();
		for (byte b : byte1) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bytes2 = s.getBytes("gbk");
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bytes3 = s.getBytes("utf-8");
		for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");

		}
		System.out.println();
		byte[] bytes4 = s.getBytes("utf-16be");
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		String str1 = new String(bytes4);// java默认jbk编码，在反编译时候要注明编码类型
		System.out.println(str1);
		String str2 = new String(bytes4, "utf-16be");
		System.out.println(str2);
	}

}
