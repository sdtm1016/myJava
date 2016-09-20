package pattern.startegy.instence;

public class DuckTest {

	public static void main(String[] args) {
		System.out.println("*******测试鸭子的程序**********");
		Duck duck = null;
		duck = new MallardDuck();
		duck = new ReadheadDuck();
		duck = new RubberDuck();
		duck = new BigYellow();
		duck = new SpaceDuck();
		duck.diaplay();
		duck.quack();
		duck.fly();
		System.out.println("*********测试完毕************");
	}

}