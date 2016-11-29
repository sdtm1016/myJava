package collection.list;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import collection.javaBean.Student;

public class Demo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// int[] arr = new int[2];
		// int x = arr.length;

		// 不加泛型
		List list = new ArrayList();
		list.add("123");
		list.add(10);
		list.add(new Integer(2));
		list.add(new Long(1));
		// 通过debug查看元素的类型,或者遍历
		System.out.println(list.size());
		// 遍历集合 MyList.get(i)
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}
		System.out.println("<---for 遍历");

		// instanceof判断
		for (Object obj : list) {
			System.out.print(obj.getClass().getSimpleName() + " : ");
			if (obj instanceof String) {
				System.out.println((String) obj);
			} else if (obj instanceof Integer) {
				System.out.println((Integer) obj);
			} // ...其他
			else if (obj instanceof Long) {
				System.out.println((Long) obj);
			}
		}

		// 迭代器
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ",");
		}
		System.out.println("<---iterator 遍历");

		// 当再次使用循环,不会打印东西
		System.out.println("it第二次使用为空:");
		for (; it.hasNext();) {
			System.out.println(it.next());
		}

		list = new ArrayList<>();
		// String
		list.add("tom");
		list.add("tomas");
		list.add("tomasLee");
		// Integer
		list.add(100);
		list.add(200);
		// Students
		Student stu1 = new Student();
		stu1.setAge(11);
		stu1.setName("stu1");
		stu1.setSex('g');
		list.add(stu1);
		list.add(new Student("stu2", 13, 'b'));
		list.add(new Student("stu3", 15));

		Object o = null;// o在循环外定义
		for (int i = 0; i < list.size(); i++) {
			o = list.get(i);
			// ...Student.toString
			if (o instanceof Student) {
				System.out.println(o);
			}
		}

		// 泛型后list只能为泛型的对象
		List<Student> lst = new ArrayList<Student>();
		lst.add(new Student("stu1", 10, 'b'));
		lst.add(new Student("stu2", 11, 'g'));
		// 泛型的遍历可以直接用Studnet,不用Object后强制转换
		System.out.println(lst);
		// JDK1.5之后添加增强for
		System.out.println("增强for循环遍历");
		for (Student student : lst) {
			System.out.println(student);
		}

		// LinkedList
		Deque<String> dq = new LinkedList<String>();
		dq.add("tom");
		dq.add("tomas");
		dq.add("tomasLee");
		System.out.println(dq);
		it = dq.iterator();
		// iterator遍历
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("dq.getLast(): " + dq.getLast());
		System.out.println("((LinkedList) dq).get(1): "
				+ ((LinkedList) dq).get(1));
		// contains通过返回indexOf(o) != -1
		System.out.println(dq.contains(new String("tomas")));

		List<Student> list100 = new ArrayList<Student>();
		for (int i = 0; i < 100; i++) {
			list100.add(new Student("tom" + i, i));
		}
		Student s9 = new Student("tom9", 9);
		// ArrayList的indexOf实现是通过equals比较,
		// 如果Students中没有复写equals,将使用Object的equals,结果就是false
		System.out.println(list100.contains(s9));
	}
}