设计:
WeatherSubject
属性:List<Observer> observers
方法:attach/detach/notifyObservers
关键点:notifyObservers()方法是调用observers.update(this)
ConcreteWeatherSubject
weatherContent	get/set

Observer:interface
update
ConcreteObserver
属性:observerName	weatherContent	remindThing
方法:get/set
update实现:通过subject获取weatherContent完成更新

Client:
1.new ConcreteWeatherSubject;-->set..
2.new ConcreteObserver();
3.attach
4.改变状态
WeatherSubject.setWeatherContent
-->this.weatherContent = weatherContent;
-->ConcreteWeatherSubject.setWeatherContent()
	通知所有注册的观察着对象进行更新
	-->WeatherSubject.notifyObservers-->Observer.update(WeatherSubject)
		//回调subject,获取相应数据
		-->weatherContent = ((ConcreteWeatherSubject) subject).getWeatherContent();
		-->ConcreteObserver.update(WeatherSubject)