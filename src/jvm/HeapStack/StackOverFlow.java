package jvm.HeapStack;

// -verbose:gc -Xms10M -Xmx10M -Xss128k -XX:+PrintGCDetails

public class StackOverFlow {

	private static int counter = 0;

	public void count() {
		
		System.out.println("Stack frame depth is : " + (++counter));
		count();
	}

	public static void main(String[] args) {

		System.out.println("HelloStackOverFlow");
		StackOverFlow helloStackOverFlow = new StackOverFlow();
		try {
			helloStackOverFlow.count();
		} catch (Exception e) {
			System.out.println("Stack frame depth is : " + (++counter));
			e.printStackTrace();
			throw e;
		}
	}
}
