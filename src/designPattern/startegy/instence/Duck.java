package designPattern.startegy.instence;

import designPattern.startegy.FlyingStragety;

/*
 * 超类，所有的鸭子都要继承此类
 * 抽象类鸭子的行为：外表和鸣叫
 */
public abstract class Duck {

	/*
	 * 鸭子发出叫声 通过行为，由超类实现
	 */
	public void quack() {
		System.out.println("嘎嘎嘎");
	}

	/*
	 * 要是鸭子的外观 鸭子的外观各不相同，声明为abstract,由子类实现
	 */
	public abstract void diaplay();


	public void setFlyingStagety(FlyingStragety flyingStagety) {
		this.flyingStagety = flyingStagety;
	}

	//如果所有的实现类后来都要添加方法,可以在这里定义
	//然而很多时候,只是一部分实现Duck类需要定义
	private FlyingStragety flyingStagety;

	//fly,调用接口的抽象方法
	public void fly() {
		flyingStagety.performFly();
	}

}