package pattern.startegy;

public class FlyWithRockect implements FlyingStragety {
	
	@Override
	public void performFly() {
		System.out.println("用火箭飞行");
	}
}
