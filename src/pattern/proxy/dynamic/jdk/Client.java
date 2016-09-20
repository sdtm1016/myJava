package pattern.proxy.dynamic.jdk;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import pattern.proxy.Car;
import pattern.proxy.Moveable;

public class Client {
	/**
	 * JDK动态代理测试类
	 */
	public static void main(String[] args) {
		//
		Car car = new Car();
		//TimHandler对象向上转型
		InvocationHandler h = new TimeHandler(car);
		//cls 类类型: class study.proxy.staticDemo.Car
		Class<?> cls = car.getClass();
		/**
		 * Proxy动态代理类
		 * loader 类加载器 
		 * interface 实现接口
		 * h InvocationHanler（事务处理器）
		 */
		//返回的对象都是动态的代理对象，用统一实现的接口类来接收
		//cls.getClassLoader():类加载器对象:sun.misc.Launcher$AppClassLoader@409a44d6
		//cls.getInterfaces():类所实现的接口类型:[Ljava.lang.Class;@39ea2de1
		//Proxy提供创建动态代理对象的静态方法和接口
		//Proxy也是这些动态代理类的超类
		Moveable m = (Moveable) Proxy.newProxyInstance(
				cls.getClassLoader(), cls.getInterfaces(), h);
		m.move();
	}
}