package collection.demo.pokeGame.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import collection.demo.pokeGame.item.Player;

/**
 * 玩家注册,验证类 提供输入,返回玩家信息 如果验证失败,主程序退出!!
 */
public class PlayerRegistered {

	private Player p;
	static int count;
	Scanner in;

	// PlayerRegistered的唯一入口,其他封装其他方法.
	public Player playerBuilder() throws Exception {
		p = new Player();
		inputId();
		if (p.getId() == 0) {
			throw new RuntimeException();
		}
		inputName();
		return p;
	}

	private void inputName() {
		in = new Scanner(System.in);
		System.out.println("请输入姓名");
		p.setName(in.next());
	}

	private void inputId() {
		if (count == 3) {
			System.out.println("对不起,输出次数达到上限,系统退出");
			return;
		}
		count++;
		in = new Scanner(System.in);
		System.out.println("请输出入id");
		try {
			int id = in.nextInt();
			if (id <= 0) {
				// 这里可以设置一个与nextInt()不同的异常,
				// 然后再分别catch处理,我这里简单的统一处理了
				throw new RuntimeException();
			}
			p.setId(id);
		} catch (Exception e) {
			if (count < 3) {
				System.out.println("对不起,请输出一个正整数,(还有" + (3 - count) + "次机会)");
			}
			inputId();
		}
	}

	static int sum = 0;

	public void winSum(Player p) {
		sum++;
		double i = p.getSum();
		i++;
		p.setSum((int) i);
		System.out.println(p.getName() + "共参加场次" + sum + ";胜场数" + p.getSum());
		double d = (double) i / sum;
		NumberFormat nf = new DecimalFormat("0.00");
		System.out.println("胜率:" + nf.format(d));
	}

}
