package math.sort;

import java.util.Arrays;


//插入排序,从数字依次取出元素插入到有序部分的队列中

public class InsertDemo {
	static int sort = 0;
	// int[] a = { 1, 5, 2, 4, 3, 7, 0 };
	int[] a = { 6, 5, 4, 3, 2, 1, 0 };

	public void insert() {
		for (int i = 1; i < a.length; i++) {
			// 1.初始化x和k,即:待插入值a[i],空位索引j
			int x = a[i];
			int j = i - 1;
			System.out.println("x=a[" + i + "]" + "=" + x);

			// 2. 将有序队列中比 x 大的值 a[j] 依次右移,j--循环同时记录也是记录空位索引
			for (; j >= 0 && x < a[j]; j--) {
				// System.out.println("a[" + (j + 1) + "]:" + a[j + 1] + "-->");
				a[j + 1] = a[j];
			}
			System.out.println("x=a[" + j + "]" + "=" + x);
			// 3.插入x
			a[j + 1] = x;// 由于for循环体最后复合条件后会再次j--,在这里要加回来
			System.out.println(Arrays.toString(a));
		}
	}

	// 算法细节说明版本
	// 初始化:a{a[0]},即a[0]有序,a[i,a.length]无序
	// 不变式:保持a[0,i-1]==>加入a[i]后a[0,i]有序
	// 实现:x暂存a[i]并比较a[j]-->a[i-1,0],找出正确的空位索引后插入x,使a[1,i]有序
	// 终止:a[0,i-1]加入a[i]即:a[0,a.length]有序
	public void ascInsertWithDescIndex() {
		for (int i = 1; i < a.length; i++) {
			// 1. x暂存待插入值a[i], 初始化空位索引
			int x = a[i];
			int j = i - 1;

			// x=a[i]-->a[1,a.length-1]迭代比较a[j]-->a[0,i-1]
			while (j >= 0 && x < a[j]) {
				// 2.比x大的值a[j]右移,同时空位索引减一
				a[j + 1] = a[j];
				j--;
			}
			// 3.插入
			a[j + 1] = x;
			System.out.println(Arrays.toString(a));
		}
	}

	public void ascInsertWithAscIndex() {
		// x=a[i]-->a[0 ~ a.length-2]迭代比较a[j]-->a[i ~ a.length-1]
		// while规则: x > a[j],a[j]左移,x右移,索引j自增
		for (int i = a.length - 2; i >= 0; i--) {
			int x = a[i];
			int j = i + 1;
			while (j < a.length && x > a[j]) {
				// x右移
				a[j - 1] = a[j];
				a[j] = x;
				j++;
			}
			System.out.println(Arrays.toString(a));
		}
	}

	// 降序只是将while中比较规则更改即可,其他不动
	public void descInsertWithDescIndex() {
		for (int i = 1; i < a.length; i++) {
			int x = a[i];
			int j = i - 1;
			while (j >= 0 && x > a[j]) {
				a[j + 1] = a[j];
				a[j] = x;
				j--;
			}
		}
	}

	public void descInsertWithAscIndex() {
		for (int i = a.length - 2; i >= 0; i--) {
			int x = a[i];
			int j = i + 1;
			while (j < a.length && x < a[j]) {
				// x右移
				a[j - 1] = a[j];
				a[j] = x;
				j++;
			}
		}
	}


	public static void main(String[] args) {
		InsertDemo insert = new InsertDemo();
		insert.insert();
	}
}
