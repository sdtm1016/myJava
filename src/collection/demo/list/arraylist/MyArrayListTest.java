package collection.demo.list.arraylist;

import collection.demo.list.MyList;

public class MyArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyList list = new MyArrayList();
		try {
			list.add(0, new Students("S0001", "张三", "男", 18));
			list.add(1, new Students("S0002", "李四", "男", 19));
			list.add(2, new Students("S0003", "王五", "女", 21));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*************************");
		for (int i = 0; i < list.size(); i++) {
			try {
				System.out.println(list.get(i).toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			list.delete(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("##############################");
		for (int i = 0; i < list.size(); i++) {
			try {
				System.out.println(list.get(i).toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}