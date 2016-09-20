package pattern.startegy.instence;

import pattern.startegy.FlyNoWay;

public class RubberDuck extends Duck {

	
	public RubberDuck() {
		super();
		super.setFlyingStagety(new FlyNoWay());
	}

	@Override
	public void diaplay() {
		System.out.println("我全身发黄，嘴巴很红");
	}
	
	public void quack(){
		System.out.println("噶~噶~噶~");
	}

}