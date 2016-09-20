package thread.producerConsumer.demo2;

public class Bear extends Thread {
	private static final int EAT = 12;
	private Box box;
	private String name;

	public Bear(String name, Box box) {
		this.name = name;
		this.box = box;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);// 熊比较懒,先睡5s再去吃
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized (box) {
				// 1.box够熊吃
				if (box.capacity >= Box.MAX) {
					box.capacity -= EAT;
					System.out.println(name + "吃掉" + EAT + "; Box="
							+ box.capacity);
					box.notifyAll();
					// Thread.yield();
				} else {
					try {
						// System.out.println("box剩余" + box.capacity + "; " +
						// name + "等待");
						box.wait();// 等待蜜蜂唤醒
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}