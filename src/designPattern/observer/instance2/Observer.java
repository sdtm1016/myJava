package designPattern.observer.instance2;

//定义一个更新的接口方法给那些在目标发生改变的时候被通知的观察者对象调用
public interface Observer {

	// 更新的接口
	public void update(WeatherSubject subject);

	// 设置观察者名称
	public void setObserverName(String observerName);

	// 取得观察者明着
	public String getObserverName();
}