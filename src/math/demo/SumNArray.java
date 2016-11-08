package math.demo;

/**
 * 和为n的连续正数序列
 */
public class SumNArray {
	public static void main(String[] args) {
		int n = 15890;
		int small = 1;
		int big = 2;
		int mid = (1 + n) / 2;
		int sum = small + big;
		while (small < mid) {
			if (sum == n) {
				for (int i = small; i <= big; i++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			while (sum > n) {
				sum -= small;
				small++;
				if (sum == n) {
					for (int i = small; i <= big; i++) {
						System.out.print(i + " ");
					}
					System.out.println();
				}
			}
			big++;
			sum += big;
		}
	}
}
