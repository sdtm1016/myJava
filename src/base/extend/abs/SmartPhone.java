package base.extend.abs;

public class SmartPhone extends Telphone implements IPlayGame {
	@Override
	public void call() {
		System.out.println("通过语音打电话");
	}

	@Override
	public void message() {
		System.out.println("通过语音发短信");
	}

	@Override
	public void playgame() {
		System.out.println("具有玩游戏的功能");
	}
}
