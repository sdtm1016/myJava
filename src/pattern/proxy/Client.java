package pattern.proxy;

public class Client {

	public static void main(String[] args) {
		// 直接调用
		Car c1 = new Car();
		c1.move();

		// -->继承,向上转型后调用
		Moveable m1 = new Car();
		m1.move();

		// -->聚合,CarTimeProxy传参c2实例化
		Car c2 = new Car();
		Moveable m2 = new CarTimeProxy(c2);
		//m2.move()调用Car.move()
		m2.move();

		// -->利用传参，和统一的接口
		// 从Car对象到CarTimeProxy对象,然后到CarLogProxy对象！
		// 继承方法的复写、添加逻辑
		// 通过传参的顺序也可以实现先后顺序
		Car car = new Car();
		CarTimeProxy ctp = new CarTimeProxy(car);
		CarLogProxy clp = new CarLogProxy(ctp);
		clp.move();

	}
}