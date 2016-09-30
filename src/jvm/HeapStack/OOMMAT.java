package jvm.HeapStack;

public class OOMMAT {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		final int size = 512 * 1024 * 1024;
		byte[] array1 = new byte[size];
		byte[] array2 = new byte[size];
		byte[] array3 = new byte[size];
		byte[] array4 = new byte[size];
		byte[] array5 = new byte[size];
	}
}
