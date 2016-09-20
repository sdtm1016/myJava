package thread.producerConsumer.demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		Storage s = pc.new Storage();

		ExecutorService server = Executors.newCachedThreadPool();
		Producer p = pc.new Producer("张三", s);
		Producer p2 = pc.new Producer("李四", s);
		Consumer c = pc.new Consumer("王五", s);
		Consumer c2 = pc.new Consumer("老刘", s);
		Consumer c3 = pc.new Consumer("老林", s);
		server.submit(p);
		server.submit(c);
		server.submit(c);
		server.submit(c2);
		server.submit(c3);
	}

	// 消费者
	class Consumer implements Runnable {
		private String name;
		private Storage s = null;

		public Consumer(String name, Storage s) {
			this.name = name;
			this.s = s;
		}

		@Override
		public void run() {
			try {
				while (true) {
					System.out.println(name + "准备消费");
					Product product = s.pop();
					System.out.println(name + "已经消费(" + product.toString()
							+ ").");
					System.out.println("=====================");
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// 生产者
	class Producer implements Runnable {

		private String name;
		private Storage s = null;

		public Producer(String name, Storage s) {
			this.name = name;
			this.s = s;
		}

		@Override
		public void run() {
			try {
				while (true) {
					Product product = new Product((int) (Math.random() * 10000));
					System.out.println(name + "准备生产(" + product.toString()
							+ ").");
					s.push(product);
					System.out.println(name + "已生产(" + product.toString()
							+ ").");
					System.out.println("=======================");
					Thread.sleep(500);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	class Storage {
		BlockingQueue<Product> queues = new LinkedBlockingQueue<Product>(10);

		public void push(Product p) throws InterruptedException {
			queues.put(p);
		}

		public Product pop() throws InterruptedException {
			return queues.take();
		}
	}

	class Product {
		private int id;

		public Product(int id) {
			this.id = id;
		}

		public String toString() {
			return "产品:" + this.id;
		}

	}

}
