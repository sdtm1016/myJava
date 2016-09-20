package collection.map;

import java.util.Hashtable;

public class HashtableDemo {
	public static void main(String[] args) {
		// 将 1、2、3 这三个数字放到 Hashtable 里面，他们的 Key 分别是”one”、”two”、”three”，
		Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
		numbers.put("one", new Integer(1));
		numbers.put("two", new Integer(2));
		numbers.put("three", new Integer(3));

		// 如果我们需要取出一个数，比如 2，可以用相应的 key来取出
		Integer n = (Integer) numbers.get("two");
		System.out.println("two =" + n);

	}
}
