package designPattern.startegy;

public class FlyNoWay implements FlyingStragety {

	@Override
	public void performFly() {
		System.out.println("振翅高飞");
	}

}