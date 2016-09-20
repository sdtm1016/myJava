package pattern.startegy;

public class FlyWithWin implements FlyingStragety {

	@Override
	public void performFly() {
		System.out.println("我不会飞行");
	}

}