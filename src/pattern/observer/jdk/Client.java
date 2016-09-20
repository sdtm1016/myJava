package pattern.observer.jdk;

public class Client {

	public static void main(String[] args) {
		// 创建天气作为一个目标
		ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
		// 创建黄明的女朋友作为管出阿哲
		ConcreteObserver girl = new ConcreteObserver();
		girl.setOberverName("黄明的女朋友");

		// 创建黄明的老妈作为观察者
		ConcreteObserver mum = new ConcreteObserver();
		mum.setOberverName("黄明的老妈");

		// 注册观察者
		subject.addObserver(girl);
		subject.addObserver(mum);

		// 目标更新天气情况
		subject.setContent("今天天气晴朗，气温20度");

	}
}