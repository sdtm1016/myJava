package pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，它知道观察它的观察者，并提供注册（添加）和删除观察者的接口
 */
public class Subject {

	// 用来保存注册观察者的对象
	private List<Observer> observers = new ArrayList<Observer>();

	// attach detach notifyObservers
	public void attach(Observer observer) {
		observers.add(observer);
	}

	// 删除集合中指定观察者
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	// 通知所有注册的观察者对象
	protected void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}