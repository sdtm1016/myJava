package collection.demo.pokeGame.item;

import java.util.List;
import java.util.Scanner;

/**
 * 玩家实体类,封装name,id 玩家游戏时候获取扑克牌,所以添加cardList的属性
 */
public class Player {

	private String name;
	private int id;
	private List<Card> cardList;
	private int sum;
	Scanner in;

	public Player() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", id=" + id + "]";
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	public void addCardList(Card c) {

		this.cardList.add(c);

	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
