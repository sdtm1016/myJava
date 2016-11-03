package designPattern.observer;

/**
 * 具体的观察者对象对象，实现更新的方法，使自身的状态和目标的状态保持一致
 */
public class ConcreteObserver implements Observer {

	// 观察者的状态
	private String observerState;

	/**
	 * 获取目标类的状态同步到观察者的状态中
	 */
	@Override
	public void update(Subject subject) {
		observerState = ((ConcreteSubject) subject).getSubjectState();
	}

}