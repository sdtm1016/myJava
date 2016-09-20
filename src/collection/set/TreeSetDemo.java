package collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import collection.javaBean.Dog;
import collection.javaBean.Person;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TreeSet中加入的对象必须实现Comparable
		// 这里临时在TreeSet类中通过匿名类实现Comparator比较器,保证Person可比较性
		Comparator<Person> comp = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// 这里自定义仅按照年龄倒序排序
				int m = (o1 == null ? 0 : o1.getAge());
				int n = (o2 == null ? 0 : o2.getAge());

				// return o2.getAge() - o1.getAge();
				return n - m;
			}
		};
		// 通过比较器comp构造TreeSet
		TreeSet<Person> ts = new TreeSet<Person>(comp);
		ts.add(null);
		ts.add(new Person("toms", 11));
		ts.add(new Person("tom", 10));
		ts.add(new Person("tomsLee", 12));
		for (Person person : ts) {
			System.out.println(person == null ? "nobody-0" : person.getName()
					+ "-" + person.getAge());

		}
		System.out.println(ts);
		// 通过添加实现Comparable的对象
		TreeSet<Dog> tsd = new TreeSet<Dog>();
		tsd.add(new Dog("black", 10, "京巴"));
		tsd.add(new Dog("black", 12, "京巴"));
		// tsd.add(new Dog("black", 12, null));
		tsd.add(new Dog("white", 12, "京巴"));
		tsd.add(new Dog("yellow", 12, "藏獒"));
		tsd.add(new Dog("white", 12, "藏獒"));
		for (Iterator<Dog> it = tsd.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

}