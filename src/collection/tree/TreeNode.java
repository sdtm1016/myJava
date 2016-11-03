package collection.tree;

/**
 * 二叉树node数据结构
 * 构建平衡二叉树需要先排序
 * 二叉树的遍历（前序，中序，后序）效率要比数组低很多
 */
public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;

	public void store(int value) {
		if (value < this.value) {
			if (left == null) {
				left = new TreeNode();
				left.value = value;
			} else {
				left.store(value);
			}
		} else if (value > this.value) {
			if (right == null) {
				right = new TreeNode();
				right.value = value;
			} else {
				right.store(value);
			}
		}
	}

	public boolean find(int value) {
		System.out.println("happen " + this.value);
		if (value == this.value) {
			return true;
		} else if (value > this.value) {
			if (right == null) return false;
			return right.find(value);
		} else {
			if (left == null) return false;
			return left.find(value);
		}

	}

	public void preList() {
		System.out.print(this.value + ",");
		if (left != null) left.preList();
		if (right != null) right.preList();
	}

	public void middleList() {
		if (left != null) left.preList();
		System.out.print(this.value + ",");
		if (right != null) right.preList();
	}

	public void afterList() {
		if (left != null) left.preList();
		if (right != null) right.preList();
		System.out.print(this.value + ",");
	}

	public static void main(String[] args) {
		int[] data = new int[20];
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * 100) + 1;
			System.out.print(data[i] + ",");
		}
		System.out.println();

		TreeNode root = new TreeNode();
		root.value = data[0];
		for (int i = 1; i < data.length; i++) {
			root.store(data[i]);
		}

		root.find(data[19]);

		root.preList();
		System.out.println();
		root.middleList();
		System.out.println();
		root.afterList();
	}
}