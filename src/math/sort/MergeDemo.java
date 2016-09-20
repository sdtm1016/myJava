package math.sort;

import java.util.Arrays;


public class MergeDemo {

	public void merge(int[] a, int p, int q, int r) {
		// L[m+1] = a(p,q]+Integer.MAX_VALUE
		int m = q - p + 1;
		// R[n+1] = a[q+1,r]+Integer.MAX_VALUE
		int n = r - q + 1 - 1;
		int L[] = new int[m + 1];
		int R[] = new int[n + 1];
		for (int i = 0; i < m; i++) {
			L[i] = a[p + i];
		}
		L[m] = Integer.MAX_VALUE;
		System.out.print("L: ");
		System.out.println(Arrays.toString(L));
		for (int j = 0; j < n; j++) {
			R[j] = a[q + j + 1];
		}
		R[n] = Integer.MAX_VALUE;
		System.out.print("R: ");
		System.out.println(Arrays.toString(R));
		int i = 0;
		int j = 0;
		// a[k]-->a[p,r]
		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}
		}
		System.out.print("a: ");
		System.out.println(Arrays.toString(a));
		System.out.println("-------------------------------");
	}

	public void mergeSort(int[] a, int p, int r) {
		if (p < r) {
			// 分割数组排序
			// 求出q=p时候,在次迭代-->p=r不处理
			int q = (p + r) / 2;
			// 即:迭代切分到单个元素的数组
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			// return后,合并字数组
			merge(a, p, q, r);
		}

	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 2, 4, 3, 7, 0 };
		MergeDemo merge = new MergeDemo();
		merge.mergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
