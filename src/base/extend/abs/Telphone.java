package base.extend.abs;

public abstract class Telphone {
	public abstract void call();

	public abstract void message();
}

class Cellphone extends Telphone {
	@Override
	public void call() {
		System.out.println("通过键盘打电话");
	}

	@Override
	public void message() {
		System.out.println("通过键发短信");
	}
}