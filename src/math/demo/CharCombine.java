package math.demo;

import java.util.LinkedList;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class CharCombine {

	public static void main(String[] args) {
		test1();
		test2();
	}

	public static void test1() {
		char[] c = new char[]{'a', 'b', 'c'};
		int length = c.length;
		int max = 1 << length;
		for (int i = 1; i <= max; i++) {
			for (int j = 0; j < length; j++) {
				if (((1 << j) & i) != 0) {
					System.out.print(c[j]);
				}
			}
			System.out.println("");
		}
	}

	public static void test2() {
		char[] c = new char[]{'a', 'b', 'c'};
		for (int i = 1; i <= c.length; i++) {
			LinkedList<Character> list = new LinkedList<Character>();
			iterator(c, 0, i, list);

		}


	}

	public static void iterator(char[] c, int begin, int tag, LinkedList<Character> list) {
		if (tag == 0) {
			for (Character character : list) {
				System.out.print(character);
			}
			System.out.println();
			return;
		}
		if (begin == c.length)
			return;
		list.add(new Character(c[begin]));
		iterator(c, begin + 1, tag - 1, list);
		list.remove(new Character(c[begin]));
		iterator(c, begin + 1, tag, list);
	}
}
