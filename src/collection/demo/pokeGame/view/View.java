package collection.demo.pokeGame.view;

import java.util.List;

import collection.demo.pokeGame.item.Card;
import collection.demo.pokeGame.item.Player;
import collection.demo.pokeGame.util.GamePlaying;
import collection.demo.pokeGame.util.PlayerRegistered;
import collection.demo.pokeGame.util.Utils;

/**
 * 主函数的入口,向控制台提供简单的视图 调用util和PlayerRegistered实现各种功能..
 */
public class View {

	public static void main(String[] args) {

		Utils util = new Utils();
		System.out.println("------------创建扑克牌------------");
		List<Card> cardList = util.createCard();
		System.out.println(cardList);
		// 可以验证一下,sort功能是否正确,查看sort后扑克牌大小顺序
		// util.sortCard(cardList);
		System.out.println("-----------扑克牌创建成功----------");
		System.out.println("------------玩家注册……-------------");

		PlayerRegistered pr = new PlayerRegistered();
		Player p1, p2;
		// try-catch判断是否退出主函数体
		try {
			p1 = pr.playerBuilder();
			p2 = pr.playerBuilder();
		} catch (Exception e) {
			return;
		}

		System.out.println("注册的玩家为:");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		try {
			new GamePlaying().playGames(cardList, p1, p2);
		} catch (Exception e) {
			return;
		}
	}
}
