package math.sort;

import java.util.Arrays;

//在无序的队列中选择出最小的元素,放入有序队列末尾
public class SelectDemo {
	// int[] a = { 6, 5, 4, 3, 2, 1, 0 };
	static int[] a = { 8, 5, 5, 2, 4, 3, 7, 0 };

	// 理解
	public void sort() {
		for (int i = 0; i < a.length; i++) {
			int k = i;// 保存最后得到最小值的位置
			int min = a[i];// 用于循环比较相对最小值
			for (int j = i; j < a.length; j++) {
				if (a[j] < min) {// 复合条件后对k和min修改
					min = a[j];
					k = j;
				}
			}
			a[k] = a[i];
			a[i] = min;
			System.out.println(Arrays.toString(a));
		}
	}

	// 优化:当然上面k和min是同一个元素的值和位置,可以合并
	public void sort1() {
		for (int i = 0; i < a.length; i++) {
			int k = i;// 仅保存最小值的位置
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[k]) {// 二次循环中减少一次赋值运算
					k = j;
				}
			}
			int min = a[k];
			a[k] = a[i];
			a[i] = min;
			System.out.println(Arrays.toString(a));
		}
	}

	// 算法说明
	public void ascSelectAscIndex() {
		// 初始化: a[0,i]即a[0]有序, min = a[0], a[1,a.length]无序
		// 保持不变式:a[0,i]有序==>加入a[i+1]即a[j]-->a[i,a.length-1]后,a[0,i+1]有序
		// 算法实现:k标记最小值索引,遍历a[j]-->a[i,a.length-1]比较a[k]最终找出最小值的索引赋值给k,
		// 终止:a[0,a.length]有序,同时内部循环j初始化a.length即:无序队列为null
		for (int i = 0; i < a.length; i++) {
			// 1.初始化min的位置索引k
			int k = i;
			// 2.找出min对应的索引,a[i,a.length]无序,必须用for循环,且不能将判断条件放入for内
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[k]) {
					k = j;
				}
			}
			// 3.通过索引互换(最小值a[k],存放位置a[i])
			int min = a[k];
			a[k] = a[i];
			System.out.println("a[" + i + "]=" + a[i] + "-->" + "a[" + k + "]");
			a[i] = min;
			System.out.println("a[" + k + "]=" + min + "-->" + "a[" + i + "]");
			System.out.println(Arrays.toString(a));
		}
	}

	// 升序,这里在二次循环中进行一次位置交换,最差会增加3倍时间,所有效率会很差
	public void descSelectAscIndex() {
		// 初始化: min = a[i];
		// 保持不变式:a[0,i-1]有序且a[i-1]< a[j]-->a[i,a.length-1]
		// 终止:
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int max = a[i];
				if (a[j] > max) {
					a[i] = a[j];
					a[j] = max;
				}
			}
		}
	}

	public void descSelectAscIndex2() {
		for (int i = 0; i < a.length; i++) {
			int k = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[k]) {
					k = j;
				}
			}
			int max = a[k];
			a[k] = a[i];
			a[i] = max;
		}
		System.out.println(Arrays.toString(a));
	}

	public void ascSelectDescIndex() {
		// 初始化: min = a[i];
		// 保持不变式:a[0,i-1]有序且a[i-1]< a[j]-->a[i,a.length-1]
		// 终止:
		for (int i = 0; i < a.length; i++) {
			int k = i;
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[k]) {
					k = j;
				}
			}
			int min = a[k];
			a[k] = a[i];
			a[i] = min;
		}
		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		SelectDemo select = new SelectDemo();
		select.descSelectAscIndex();
		System.out.println(Arrays.toString(a));
	}
}
