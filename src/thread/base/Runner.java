package thread.base;

public class Runner implements Runnable {

	private static int length = 0;

	public void run() {
		while (true) {
			System.out.println("I am " + Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (new Object()) {

				System.out.println(Thread.currentThread().getName() + " run "
						+ (length++) + " m");
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner(), "runner1");
		Thread t2 = new Thread(new Runner(), "runner2");
		Thread t3 = new Thread(new Runner(), "runner3");
		t1.start();
		t2.start();
		t3.start();
	}
}
