package base.extend.abs;

public interface IPlayGame {
	public void playgame();
}

class Psp implements IPlayGame {

	@Override
	public void playgame() {
		System.out.println("具有玩游戏的功能");

	}

}
