package math.demo;

/**
 * 题目：求子数组的最大和
 * 输入一个整形数组，数组里有正数也有负数。
 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n) 。
 * <p>
 * 例如输入的数组为 1, -2, 3, 10, -4, 7, 2, -5 ，
 * 和最大的子数组为 3, 10, -4, 7, 2 ，因此输出为该子数组的和18 。
 */
public class FindBigestSumOfSubArray {
	public static void main(String[] args) {
		int[] arrays = {-1, -2, -3, -4};
		// int[] arrays = {1,-2,3,10,-4,7,2,-5};
		int currentSum = 0;
		int maxSum = -1 << 31;
		for (int i = 0; i < arrays.length; i++) {
			currentSum += arrays[i];

			if (currentSum > maxSum) {

				maxSum = currentSum;
				System.out.println(arrays[i]);
			} else if (currentSum < 0) {
				currentSum = 0;
				System.out.println(arrays[i]);
			}
		}
		System.out.println("最大和是：" + maxSum);
	}
}
