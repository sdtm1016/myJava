package jvm.HeapStack;

import java.util.ArrayList;
import java.util.List;

public class JVMDoEscape {

	public static void main(String[] args) {
		test();
		// test2();
	}

	// 内存逃逸
	public static void test() {
		Worker worker = new Worker();
		while (true) {
			worker.useWorker();
		}
	}

	//
	public static void test2() {
		List<Worker> workers = new ArrayList<Worker>();
		while (true) {
			Worker worker = new Worker();
			workers.add(worker);
		}
	}
}

class Worker {
	public Worker worker;

	public Worker getWorker() {// 方法返回值，发生逃逸
		return null == worker ? new Worker() : worker;
	}

	public void setWorker() {// 给全局变量赋值，发生逃逸
		worker = new Worker();
	}

	public void useWorker() {// 实例引用传递，发生逃逸
		Worker obj = getWorker();
	}

	// 这个对象没有被使用，作用阈仅仅限制与方法体内部,不会发生对象逃逸，其实也不会在堆栈中
	public void useWorker2() {
		Worker obj = new Worker();
	}
}
