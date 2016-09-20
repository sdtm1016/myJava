package collection.demo.pokeGame.item;

/**
 * Card类,封装单张扑克牌的属性point,variety
 */
public class Card implements Comparable<Card> {

	private String point;
	private String variety;
	private String[] p = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	private String[] v = { "黑桃", "红桃", "梅花", "方块" };

	public String getVariety() {
		return variety;
	}

	public void setVariety(int variety) {
		this.variety = v[variety];
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = p[point];
	}

	public Card() {

	}

	@Override
	public String toString() {
		return this.getVariety() + this.getPoint();
	}

	@Override
	public int compareTo(Card o) {
		String sortp = "12345678910JQKA";
		String sortv = "方块梅花红桃黑桃";
		int p = sortp.indexOf(this.getPoint()) - sortp.indexOf(o.getPoint());
		int v = sortv.indexOf(this.getVariety()) - sortv.indexOf(o.getVariety());
		// String str2 = "黑桃红桃梅花方块";
		return p * 4 + v / 2;
	}

}
