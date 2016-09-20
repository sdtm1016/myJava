package collection.demo.pokeGame.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import collection.demo.pokeGame.item.Card;
import collection.demo.pokeGame.item.Player;

/**
 * 本类为View提供与扑克牌相关的各种方法
 *
 */
public class Utils {

	List<Card> cardList = new ArrayList<Card>();

	// 制作扑克牌
	public List<Card> createCard() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				Card card = new Card();
				card.setPoint(i);
				card.setVariety(j);
				cardList.add(card);
			}
		}
		System.out.println();
		return cardList;
	}

	// 扑克牌排序,为了验证是否能够比较大小,可以删除此方法
	public void sortCard(List<Card> cardList) {
		Collections.sort(cardList);
		System.out.println(cardList);
	}

	// 洗牌
	public void shffleCard(List<Card> cardList) {
		Collections.shuffle(cardList);
	}

	// 为p1,p2发扑克牌
	public void dealCard(Player p1, Player p2, List<Card> cardList) {
		int i = 1;
		p1.setCardList(new ArrayList<Card>());
		p2.setCardList(new ArrayList<Card>());
		Iterator<Card> iterator = cardList.iterator();
		while (iterator.hasNext()) {
			if (i % 2 == 1) {
				System.out.println("玩家" + p1.getName() + "拿牌");
				p1.addCardList(iterator.next());
			}
			if (i % 2 == 0) {
				System.out.println("玩家" + p2.getName() + "拿牌");
				p2.addCardList(iterator.next());
			}
			if (i >= 4) {
				break;
			}
			i++;
		}
	}

	public Player pointCard(Player p1, Player p2) {
		// 在这里可以取以中转变量:maxP1,maxP2
		/*
		 * Card maxP1 = Collections.max(p1.getCardList()); Card maxP2 =
		 * Collections.max(p1.getCardList());
		 */
		System.out.println(p1.getName() + "最大的手牌为" + Collections.max(p1.getCardList()));
		System.out.println(p2.getName() + "最大的手牌为" + Collections.max(p2.getCardList()));

		List<Card> sum = new ArrayList<Card>();
		// 这里的sum可以直接添加注释中的maxP1,maxP2,一个意思...
		sum.addAll(p1.getCardList());
		sum.addAll(p2.getCardList());
		Card max = Collections.max(sum);
		Player winner = sum.indexOf(max) <= 2 ? p1 : p2;
		System.out.println("玩家" + winner.getName() + "赢");
		System.out.println("两人的手牌分别为:");
		System.out.println("玩家" + p1.getName() + "手牌为:" + p1.getCardList());
		System.out.println("玩家" + p2.getName() + "手牌为:" + p2.getCardList());
		return winner;
	}

}
