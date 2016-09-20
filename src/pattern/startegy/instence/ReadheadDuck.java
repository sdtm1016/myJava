package pattern.startegy.instence;

import pattern.startegy.FlyWithWin;


public class ReadheadDuck extends Duck {

	public ReadheadDuck(){
		super();
		super.setFlyingStagety(new FlyWithWin());
	}
	@Override
	public void diaplay() {
		System.out.println("我的脖子是绿色的");
	}

}