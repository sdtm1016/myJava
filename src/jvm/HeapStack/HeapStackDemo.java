package jvm.HeapStack;

public class HeapStackDemo {

	public static int count = 0;

	public static void out() {
		count++;
		System.out.println("stack:" + count);
		out();
	}

	public static void main(String[] args) {
		//out();
		int[] arr1 = new int[1024 * 1024];
		byte[][] arr2 = new byte[1024 * 1024 ] [1024 * 8];
		System.out.println(arr2.length);
	}
}
