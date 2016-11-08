package math.demo;

/**
 * 矩阵相乘问题 算法导论动态规划P197
 */
public class Matrix {
	public static void main(String[] args) {

		int[] a = {30, 35, 15, 5, 10, 20, 25};
		int[][] m = new int[a.length][a.length];
		int[][] s = new int[a.length][a.length];
		int length = m.length;
		for (int i = 1; i < length; i++) {
			m[i][i] = 0;
		}

		for (int l = 2; l < length; l++) {
			for (int i = 1; i < length - l + 1; i++) {
				int j = i + l - 1;
				m[i][j] = 10000000;
				for (int k = i; k <= j - 1; k++) {
					int q = m[i][k] + m[k + 1][j] + a[i - 1] * a[k] * a[j];
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}

				}
			}
		}
		System.out.println(m[1][6]);
	}
}
