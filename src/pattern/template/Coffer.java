package pattern.template;

/*
 * 具体子类，提供了咖啡制备的具体实现
 */
public class Coffer extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("向杯中加入糖和牛奶");
	}

	@Override
	protected void brew() {
		System.out.println("用沸水冲泡咖啡");
	}

}