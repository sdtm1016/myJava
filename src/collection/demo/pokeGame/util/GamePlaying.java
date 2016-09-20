package collection.demo.pokeGame.util;

import java.util.List;
import java.util.Scanner;

import collection.demo.pokeGame.item.Card;
import collection.demo.pokeGame.item.Player;

public class GamePlaying {

	public void stop() {
		throw new RuntimeException();
	}

	static int count = 0;
	Scanner in = new Scanner(System.in);

	public void playGames(List<Card> cardList, Player p1, Player p2) throws Exception {
		Utils util = new Utils();
		System.out.println("------------开始洗牌：-------------");
		util.shffleCard(cardList);
		System.out.println("------------开始发牌：-------------");
		util.dealCard(p1, p2, cardList);
		System.out.println("------------发牌结束！-------------");
		System.out.println("------------开始游戏……-------------");
		Player winner = util.pointCard(p1, p2);
		// 这里如果后面不需要胜利玩家习题,可以把pointCard()方法改为返回值为void类型的;
		System.out.println("本局胜利者的信息为:" + winner.toString());
		new PlayerRegistered().winSum(winner);
		System.out.println("---------本局结束，再来一次吧！！----------");

		System.out.println("确认继续请按任意键,退出输入exit");

		String input = in.next();
		// System.out.println( input.trim().toUpperCase().substring(0, 1));
		if (input.trim().toUpperCase().substring(0, 1).contains("E")) {
			System.out.println("系统退出");
			return;
		} else {
			playGames(cardList, p2, p1);
		}
	}

}
