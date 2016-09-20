package math.sort;

import java.util.Arrays;


public class QuickDemo {

	public void quicksort(int[] a, int l, int r) {
		// show(a);
		if (l < r) {
			// 初始化i,j(不同阶段的空位索引),x暂存基准数a[left]
			int i = l;
			int j = r;
			int x = a[l];
			System.out.println("初始化:i" + "=" + i + ";j=" + j + ";x暂存a[" + l
					+ "]=" + a[l]);
			while (i < j) {
				// 1. a[i,right]中倒序查找比x小的位置j
				while (i < j && a[j] >= x) {
					j--;
				}
				// 替换a[j]到a[i],j为空位索引
				if (i < j) {
					System.out.println("a[" + j + "]=" + a[j] + "填补:a[" + i
							+ "]");
					a[i++] = a[j];
				}
				System.out.println(Arrays.toString(a));
				System.out.println("右空位:a[" + j + "]");
				// 2. a[i,j]中顺序找比a[j]大的位置i
				while (i < j && a[i] < a[j]) {
					i++;
				}
				// a[i]替换a[j],a[i]为空位索引
				if (i < j) {
					System.out.println("a[" + i + "]=" + a[i] + "填补:a[" + j
							+ "]");
					a[j--] = a[i];
				}
			}
			// 3. 将x填补空位a[i]
			a[i] = x;
			System.out.println("x=" + x + "填补左空位:a[" + i + "]");
			System.out.print("分步互换结果:");
			System.out.println(Arrays.toString(a));

			// 4. 递归调用,分治
			quicksort(a, l, i - 1);
			quicksort(a, i + 1, r);
		}

	}


	public static void main(String[] args) {
		int[] a = { 1, 5, 2, 4, 3, 7, 0 };
		QuickDemo quick = new QuickDemo();
		System.out.println(Arrays.toString(a));
		quick.quicksort(a, 0, a.length - 1);
	}
}
