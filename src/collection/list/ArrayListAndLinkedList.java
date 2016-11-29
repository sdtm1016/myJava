package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListAndLinkedList {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// ArrayList尾部add
		long start = System.currentTimeMillis();
		ArrayList list = new ArrayList();
		Object obj = new Object();
		for (int i = 0; i < 5000000; i++) {
			list.add(obj);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "<--ArrayList add last");
		// LinkedList尾部add
		start = System.currentTimeMillis();
		LinkedList list1 = new LinkedList();
		Object obj1 = new Object();
		for (int i = 0; i < 5000000; i++) {
			list1.add(obj1);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start + "<--LinkedList add last");
		// ArrayList开头add
		start = System.currentTimeMillis();
		Object obj2 = new Object();
		for (int i = 0; i < 1000; i++) {
			list.add(0, obj2);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start + "<--ArrayList add head");
		// LinkedList开头add
		start = System.currentTimeMillis();
		Object obj3 = new Object();
		for (int i = 0; i < 1000; i++) {
			list1.add(0, obj1);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start + "<--LinkedList add head");
		// ArrayList删除首位
		start = System.currentTimeMillis();
		list.remove(0);
		end = System.currentTimeMillis();
		System.out.println(end - start + "<--ArrayList remove head");
		// LinkedList删除第250000的位置
		start = System.currentTimeMillis();
		list1.remove(250000);
		end = System.currentTimeMillis();
		System.out.println(end - start + "<--LinkedList remove index in 250000");

	}
}
