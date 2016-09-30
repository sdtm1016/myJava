package jvm.HeapStack;

import java.util.ArrayList;
import java.util.List;

//-verbose:gc -Xms5M -Xmx5M -XX:+PrintGCDetails
public class HeapOutOfMemory {

	public static void main(String[] args) {
		System.out.println("Hello HeapOutOfMemory");
		List<Person> person = new ArrayList<Person>();
		int count = 0;
		while (true) {
			// Person p = new Person();
			// person.add(p);
			person.add(new Person());
			//System.out.println("Instance: "+(++count));
		}
	}
}

class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
