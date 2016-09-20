package pattern.proxy;

/*
 * 使用聚合的方法实现代理，一个类当中调用了另一个类的对象
 * 通过一个含参的构造方法，将Car对象传进来，在复写move方法中调用car.move();
 */
public class CarTimeProxy implements Moveable {

	private Moveable m;

	public CarTimeProxy(Moveable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行使...");
		m.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行使...行驶时间是：" + (endtime - starttime) + "毫秒");

	}

}