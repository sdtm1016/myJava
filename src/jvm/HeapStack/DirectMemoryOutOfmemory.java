package jvm.HeapStack;

import java.nio.ByteBuffer;
//-verbose:gc -XX:MaxDirectMemorySize=10M -XX:+PrintGCDetails
public class DirectMemoryOutOfmemory {

	private static final int ONE_GB = 1024 * 1024 * 1024;
	private static int count = 1;

	public static void main(String[] args) {
		try {

			while (true) {
				ByteBuffer buffer = ByteBuffer.allocateDirect(ONE_GB);
				count++;
			}
		} catch (Exception e) {
			System.out.println("Exception: instance created " + count);
			e.printStackTrace();
		} catch (Error e) {
			System.out.println("Error: instance created " + count);
			e.printStackTrace();
		}
	}
}
