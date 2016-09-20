package jvm.HeapStack;

/**
 * -verbose:gc -Xms10M -Xmx10M -Xss128k -XX:+PrintGCDetails
 */
public class HelloStackOverFlow {

	private int counter;

	public void count() {
		counter++;
		count();
	}

	public static void main(String[] args) {
		System.out.println("HelloStackOverFlow");
		HelloStackOverFlow helloStackOverFlow = new HelloStackOverFlow();
		try {
			helloStackOverFlow.count();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
