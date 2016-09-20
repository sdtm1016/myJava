package math.sort;

import java.util.Arrays;

//冒泡是一种流行但效率低的算法,反复交换相邻未排序的元素
public class BubbleDemo {
	// int[] a = { 1, 5, 2, 4, 3, 7, 0 };
	int[] a = { 6, 5, 4, 3, 2, 1, 0 };

	public void bubbleSort() {
		for (int i = 0; i < a.length - 1; i++) {
			// 算法设计:
			// 1.初始化:a[0,i]即a[0]有序
			// 2.不变式:a[0,i]有序==>加入a[i+1]即a[j]后,保持a[0,i+1]有序
			// -->实现:通过依次对a[j]<a[j-1]-->a[i,0]比较判断,然后交换位置确保有序
			// 3.终止:a[0,a.length]有序

			// 因为a[0,i]有序,可以将a[j] < a[j - 1]放入for内部,等同于while的条件
			for (int j = i + 1; j > 0 && a[j] < a[j - 1]; j--) {
				int x = a[j];// 对a[j]冒泡
				System.out.println("x=a[" + j + "]" + "=" + x);
				a[j] = a[j - 1];
				a[j - 1] = x;
			}
			System.out.println(Arrays.toString(a));

		}
	}

	public static void main(String[] args) {
		BubbleDemo bubble = new BubbleDemo();
		bubble.bubbleSort();
	}
}
