package pattern.observer.instance2;

public class ConcreteWeatherSubject extends WeatherSubject {

	// "晴天" "下雨" "下雪"
	// 目标对象的状态
	private String weatherContent;

	@Override
	protected void notifyObservers() {
		// 循环所有注册的观察者
		for (Observer observer : observers) {
			// 规则是：
			// 黄明的女朋友 需要"下雨" 的天剑通知，其他的条件不通知
			// 黄明的老妈需要 "下雨" 或者 "下雪" 的条件通知，其他的条件不通知

			// 如果天气是晴天
			// do nothing ...

			// 如果天气是下雨
			// System.out.println(observer.getObserverName());
			if ("下雨".equals(this.getWeatherContent())) {
				if ("黄明的女朋友".equals(observer.getObserverName())) {
					observer.update(this);
				}
				if ("黄明的老妈".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}

			// 如果天气是下雪
			if ("下雪".equals(this.getWeatherContent())) {
				if ("黄明的老妈".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
		}
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObservers();
	}

}