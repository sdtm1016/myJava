package designPattern.startegy.instence;

import designPattern.startegy.FlyNoWay;

public class BigYellow extends Duck {
	
	public BigYellow() {
		super();
		super.setFlyingStagety(new FlyNoWay());
	}

	@Override
	public void diaplay() {
		System.out.println("我身体很大，全身黄黄");
	}
	
	

}