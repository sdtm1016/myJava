package thread.demo;

//军队线程，墨迹作战双方的行为
public class ArmyRunnable implements Runnable {
	// volatilee 保证了线程的可以正确的读取其他线程写入的值
	// 可见性
	volatile boolean keepRunning = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (keepRunning) {
			// 发动一个五连击
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "进攻对方[" + i + "]");
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName() + "结束了战斗！");

	}

}
