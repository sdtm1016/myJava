package collection.demo.studentCourse;

import java.util.*;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class CollectionsTest {
	// Collections.sort(list);
	public void testSort() {
		List<Integer> integerList = new ArrayList<Integer>();
		Random random = new Random();
		Integer k;
		for (int i = 0; i < 10; i++) {
			do {
				k = random.nextInt(100);
			} while (integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数：" + k);
		}
		System.out.println("----------排序前----------------");
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}
		Collections.sort(integerList);
		System.out.println("----------排序后----------------");
		for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}

	}

	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenove");
		System.out.println("----------排序前----------------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
		Collections.sort(stringList);
		System.out.println("----------排序后----------------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
	}

	public void testSort3() {
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000) + " ", "Mike"));
		studentList.add(new Student(random.nextInt(1000) + " ", "Angela"));
		studentList.add(new Student(random.nextInt(1000) + " ", "Lucy"));
		System.out.println("----------排序前----------------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
		// e implement Comparable<e>{
		// override 方法 compareTo(e)}默认排序
		Collections.sort(studentList);
		System.out.println("----------按照id排序后----------------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
		// 实现Comparator<e>，临时排序
		// 定义一个排序规则的类，new comparator impletement Comparator<e>{
		// override 方法compare(e1,e2)
		// 排序使用Collections.sort(list<e>,new comparator());
		Collections.sort(studentList, new StudentComparator());
		System.out.println("----------按照姓名排序后----------------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct = new CollectionsTest();
		// ct.testSort();
		// ct.testSort2();
		ct.testSort3();

	}

}
