package thread.producerConsumer.demo2;

public class Bee extends Thread {
	private int bag = 0;
	private static final int BAG_MAX = 10;
	private static final int ONCE = 5;// 每生成5斤可以放入蜜罐中
	private static final int TIME = 100;// 生成1斤10ms
	private Box box;
	private String name;

	public Bee(String name, Box box) {
		this.name = name;
		this.box = box;
	}

	// 将bag中的蜂蜜添加到Box中
	public void put() {
		// Box可用容量与Bag蜂蜜含量比较两种情况
		int cap = box.capacity;
		int remain = Box.MAX - cap;

		// a.Box加不满
		if (remain >= bag) {
			box.capacity += bag;
			System.out.println("Box+ " + name + ".Bag(" + bag + ") = " + box.capacity);
			bag = 0;
		}
		// b.Box能够加满
		else {
			box.capacity = Box.MAX;
			bag = bag - remain;
			System.out.println("Box+ " + name + ".Bag(" + remain + "),Box满,唤醒熊");
			// 唤醒Bear,这里可以先不唤醒,在run下次循环直接进入2)的else然后唤醒
			// box.notifyAll();
			// 这里的停止使用if-else控制
			// System.out.println(name + ".box添加停止");
		}
	}

	public void run() {
		while (true) {
			// 1.蜜蜂Bag满
			if (bag >= BAG_MAX) {
				synchronized (box) {
					// 根据Box容量,判断是wait还是向Box添加蜂蜜
					if (box.capacity < Box.MAX) {
						put();
					} else {
						try {
							System.out.println(name + ".bag满," + name + "停止产蜜");
							box.wait();// 控制该线程(蜜蜂产蜜)暂停,等待熊唤醒
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

			// 2.Bag没满
			else {
				// 蜜蜂向Bag加蜜,每循环一次+1
				bag++;
				System.out.println(name + ".bag+1=" + bag);
				try {
					Thread.sleep(Bee.TIME);// 休眠10ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// 当Bag够向Box加蜜时,根据Box是否满分两种情况
				if (bag >= Bee.ONCE) {
					// 1).Box未满,一直加到满
					if (box.capacity < Box.MAX) {
						// 当Bag够5斤,添加蜂蜜
						synchronized (box) {
							put();
						}
					}
				}
				// 2).Box满,停止Bag添加
				else {
					synchronized (box) {
						box.notifyAll();// 唤醒熊
						// System.out.println(name + ".box添加停止");//
						// 这里的停止使用if-else控制
					}
				}
			}
		}
	}
}