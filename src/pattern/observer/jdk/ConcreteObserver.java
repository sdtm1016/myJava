package pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

//具体的观察者对象
public class ConcreteObserver implements Observer {

	// 观察者名称的变量
	private String observerName;

	@Override
	public void update(Observable o, Object arg) {
		// 第一种是推的模式
		System.out.println(observerName + "收到了消息，目标推送过来的是" + arg);
		// 第二种是拉的模式
		System.out.println(observerName + "收到了消息，主动到目标对象那个中去拉，拉的内容是"
				+ ((ConcreteWeatherSubject) o).getContent());
	}

	public String getOberverName() {
		return observerName;
	}

	public void setOberverName(String oberverName) {
		this.observerName = oberverName;
	}

}