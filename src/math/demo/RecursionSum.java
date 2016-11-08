package math.demo;

/**
 * 第1个人10，第2个比第1个人大2岁，依次递推，请用递归方式计算出第8个人多大？
 */
public class RecursionSum {

	public static void main(String[] args) {
		System.out.println(computeAge(8));
	}

	public static int computeAge(int n) {
		if (n == 1) return 10;
		return computeAge(n - 1) + 2;
	}

	public static void toBinary(int n, StringBuffer result) {

		if (n / 2 != 0)
			toBinary(n / 2, result);
		result.append(n % 2);
	}

}
