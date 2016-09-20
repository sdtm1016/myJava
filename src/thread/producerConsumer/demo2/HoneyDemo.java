package thread.producerConsumer.demo2;

public class HoneyDemo {
	public static void main(String[] args) {
		Box box = new Box();
		Bee bee1 = new Bee("b1", box);
		Bee bee2 = new Bee("b2", box);
		Bee bee3 = new Bee("b3", box);
		Bear bear1 = new Bear("Bear1", box);
		Bear bear2 = new Bear("Bear2", box);

		bee1.start();
		bee2.start();
		bee3.start();
		bear1.start();
		bear2.start();
	}
}