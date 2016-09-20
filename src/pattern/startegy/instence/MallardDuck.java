package pattern.startegy.instence;

import pattern.startegy.FlyWithWin;

public class MallardDuck extends Duck {

	public MallardDuck(){
		super();
		super.setFlyingStagety(new FlyWithWin());
	}
	@Override
	public void diaplay() {
		System.out.println("我的头是绿色的");
	}

}