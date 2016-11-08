package math.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * 打靶问题。一个射击运动员打靶，靶一共有10环，连开10 枪打中90环的可能性有多少？
 */
public class Shooting {
	static int totalSum = 0;

	public static void main(String[] args) {

		int sum = 90;
		int num = 10;
		List<Integer> list = new LinkedList<Integer>();
		f(num, sum, list);
	}

	public static void f(int num, int sum, List<Integer> list) {

		if (num == 1) {
			if (sum <= 10) {
				totalSum++;
				System.out.print("第" + totalSum + "种:");
				for (Integer integer : list) {
					System.out.print(" " + integer);
				}
				System.out.print(" " + sum);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i <= 10; i++) {
			list.add(i);
			f(num - 1, sum - i, list);
			list.remove(new Integer(i));
		}
	}

}
