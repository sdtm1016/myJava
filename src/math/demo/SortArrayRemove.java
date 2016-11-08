package math.demo;

/**
 * 设计一个算法，从顺序表中删除所有值为x的元素
 */
public class SortArrayRemove {
	public static void main(String[] args) {
		int[] a = {1, 2, 4, 78, 0, 45, 0, 0, 0, 89};
		int i = 0;
		while (i < a.length && a[i] != 0) {
			i++;
		}
		for (int j = i + 1; j < a.length; j++) {
			if (a[j] != 0) {
				a[i] = a[j];
				i++;
			}

		}
		for (int j = 0; j < i; j++) {
			System.out.println(a[j]);
		}


	}

}
