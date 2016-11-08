package math.demo;

/**
 * 字符串全排列算法
 */
public class StringSort {
	static char[] a = {'a', 'b', 'c', 'd', 'e'};

	/**
	 *
	 */
	public static void main(String[] args) {
// TODO Auto-generated method stub
		perm(a, 0);


	}

	public static void perm(char[] a, int begin) {
		if (begin == a.length - 1) {
			for (char c : a) {
				System.out.print(c + " ");

			}
			System.out.println();
		}
		for (int i = begin; i < a.length; i++) {
			char temp = a[i];
			a[i] = a[begin];
			a[begin] = temp;
			perm(a, begin + 1);
			temp = a[i];
			a[i] = a[begin];
			a[begin] = temp;
		}
	}
}
