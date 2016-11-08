package math.demo;

/**
 * 判断整数序列是不是二元查找树的后续遍历结果
 */
public class If2Search {
	boolean vertify(int[] sequence, int length) {
		if (sequence == null || length < 0)
			return false;
		int root = sequence[length - 1];
		int i = 0;
		for (; i < length - 1; i++) {
			if (sequence[i] > root)
				break;
		}
		int j = i;
		for (; j < length - 1; j++) {
			if (sequence[j] < root)
				return false;

		}

		boolean left = true;
		if (i > 0)
			left = vertify(sequence, i);
		boolean right = true;
		if (i < length - 1)
			right = vertify(sequence, length - i - 1);

		return left && right;

	}
}
