package pattern.proxy.dynamic.UD;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import pattern.proxy.Car;
import pattern.proxy.Moveable;

public class Client {

	/**
	 * 测试类
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Car car = new Car();
		
		InvocationHandler1 h = new TimeHandler(car);
		Moveable m = (Moveable) Proxy1.newProxyInstance(Moveable.class,h);
		m.move();
	}
}