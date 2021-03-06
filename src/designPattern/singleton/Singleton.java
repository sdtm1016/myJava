package designPattern.singleton;

/*
 *单例模式Singleton
 *应用常会：有些对象只需要一个就足够了，如古代皇帝，老婆
 *作用：保证整个应用程序中某一个实例有且只有一个
 *类型：饿汉模式，懒汉模式
 */
//饿汉基本模式
public class Singleton {
	//1.强构造方法私有化，不允许外部直接创建对象
	private Singleton() {
	}
	//2.创建一个唯一实例对象,使用private static修饰
	private static Singleton instance = new Singleton();

	//3.提供一个用于获取实例的方法，使用public static修饰
	public static Singleton getInstance() {
		return instance;
	}
}

class Singleton2 {
	private static Singleton2 instance = null;

	private Singleton2() {
	}

	//实例化放在静态代码块里可提高程序的执行效率，但也可能更占用空间
	static {
		instance = new Singleton2();
	}

	public static Singleton2 getInstance() {
		return instance;
	}
}