package pattern.observer;


/**
 * 具体的目标对象，负责把有关状态存入到相应的观察者对象中 （天气预报）
 */
public class ConcreteSubject extends Subject {

	// 目标对象的状态
	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
		this.notifyObservers();
	}
}