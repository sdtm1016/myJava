package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import collection.javaBean.Person;

public class HashSetDemo {
	public static void main(String[] args) {

		Set<Person> set = new HashSet<Person>();
		Person p1 = new Person("tom", 10);
		// set不能重复添加同一个对象(同一个物理地址)
		set.add(p1);
		set.add(p1);
		System.out.println(set.size());

		// set不能添加两个对象hashcode相同并且equals为ture的对象
		// 在这里复写Person的hashcode和equals方法方便测试
		Person p2 = new Person("tom", 10);
		set.add(p2);
		System.out.println(set.size());
		set.add(new Person("toms", 10));
		set.add(new Person("tomsLee", 10));
		System.out.println(set.size());
		System.out.println(set.contains(p2));

		// iterator遍历
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// set删除,调试分析过程
		set.remove(new Person("toms", 10));
		set.removeAll(set);
		System.out.println(set);
	}
}