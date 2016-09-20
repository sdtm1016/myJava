package pattern.singleton;

//饿汉变种模式
public class Singleton2 {
	private static Singleton2 instance = null;
	private Singleton2() {
	}
	static{
		instance = new Singleton2();
	}
	public static Singleton2 getInstance(){
		return instance;
	}
}