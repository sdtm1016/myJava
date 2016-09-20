package collection.list;

import java.util.ArrayList;
import java.util.List;

import collection.javaBean.Student;

public class ListDemo {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Student s1 = new Student("st1", 11);
		//多次添加同一个对象
		list.add(s1);
		list.add(s1);
		list.add(s1);
		System.out.println(list);
		//通过某一个引用更改这个对象,那么所有引用也会改变
		list.get(0).setName("st2");
		System.out.println(list.get(1).getName());
	}
}