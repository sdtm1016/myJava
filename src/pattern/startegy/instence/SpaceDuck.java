package pattern.startegy.instence;
import pattern.startegy.FlyWithRockect;

public class SpaceDuck extends Duck {

	public SpaceDuck() {
		super();
		super.setFlyingStagety(new FlyWithRockect());
	}

	@Override
	public void diaplay() {
		System.out.println("我头戴宇宙头盔");
	}
	
	public void quack(){
		System.out.println("我通过无线电与你通信");
	}

}