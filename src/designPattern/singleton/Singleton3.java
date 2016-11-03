package designPattern.singleton;

/*
 * 懒汉模式
 * 区别：饿汉模式的特点是加载类时比较慢，但运行时获取对象的速度比较慢，线程安全
 * 		懒汉模式的特点是加载类时比较快，但运行时湖区对象的速度比较慢，线程不安全
 */
//懒汉线程不安全模式
public class Singleton3 {

	// 1.强构造方法私有化，不允许外边直接创造对象
	private Singleton3() {
	}

	// 2.声明类的唯一实例，使用private static修饰(没有实例化）
	private static Singleton3 instance;

	// 3.提供一个获取实例的方法，使用public static 修饰（在这个方法中判断并且实例化）
	// 使用synchronized修饰保证线程安全
	public static synchronized Singleton3 getInstance() {
		if (instance == null) {
			instance = new Singleton3();
		}
		return instance;
	}
}