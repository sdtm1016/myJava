package collection.demo.list.arraylist;

import collection.demo.list.MyList;

public class MyArrayList implements MyList {
	//默认的顺序表的最大长度
	final int defaultSize = 10;
	//当前长度
	int currentSize;
	//最大长度
	int maxSize;
	//对象数组
	Object[] listArray;

	//构造方法，默认大小
	public MyArrayList() {
		init(this.defaultSize);
	}

	//构造方法，设置大小
	public MyArrayList(int length) {
		init(length);
	}

	//线性表的初始化方法
	private void init(int length) {
		maxSize = length;
		this.currentSize = 0;
		listArray = new Object[length];
	}

	//ArrayList的大小
	public int size() {
		return this.currentSize;
	}

	//ArrayList是否为空
	public boolean isEmpty() {
		return this.currentSize == 0;
	}

	//添加数据
	public void add(int index, Object obj) throws Exception {
		if (this.currentSize == this.maxSize) {
			throw new Exception("线性表已满，无法插入！");
		}
		if (index < 0 || index >= this.maxSize) {
			throw new Exception("参数错误！");
		}
		for (int j = this.currentSize; j > index; j--) {
			listArray[j] = listArray[j - 1];
		}
		listArray[index] = obj;
		this.currentSize++;
	}

	//删除数据
	public void delete(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("线性表为空，无法删除！");
		}
		if (index < 0 || index > this.maxSize - 1) {
			throw new Exception("参数错误！");
		}
		for (int j = index; j < this.currentSize - 1; j++) {
			listArray[j] = listArray[j + 1];
		}
		this.currentSize--;
	}

	//查找指定索引的数据
	public Object get(int index) throws Exception {
		if (index < 0 || index >= this.currentSize) {
			throw new Exception("参数错误！");
		}
		return listArray[index];
	}
}