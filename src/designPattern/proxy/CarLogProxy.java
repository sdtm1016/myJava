package designPattern.proxy;

/*
 * 使用聚合的方法实现代理，一个类当中调用了另一个类的对象
 * 通过一个含参的构造方法，将Car对象传进来，在复写move方法中调用car.move();
 */
public class CarLogProxy implements Moveable {

	private Moveable m;

	public CarLogProxy(Moveable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		System.out.println("汽车日志开始...");
		m.move();
		System.out.println("汽车日志结束..");

	}

}