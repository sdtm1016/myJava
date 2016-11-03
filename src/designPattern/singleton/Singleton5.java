package designPattern.singleton;

//内部类实现单例
public class Singleton5 {

	// 私有静态内部类
	private static class Singleton5Holder {
		private static final Singleton5 INSTANCE = new Singleton5();
	}

	private Singleton5() {
	}

	//外部不能直接new,也不能调用该静态内部类,只能在该类中调用,在内部类中做实例化,在getInstance中获取
	public static final Singleton5 getInstance() {
		return Singleton5Holder.INSTANCE;
	}
}
