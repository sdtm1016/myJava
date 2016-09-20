package jvm.HeapStack;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xms10M -Xmx10M -Xss128k -XX:MaxDirectMemorySize=10M
 * -XX:+PrintGCDetails
 */
public class HelloHeapOutOfMemory {

	public static void main(String[] args) {
		System.out.println("Hello HeapOutOfMemory");
		List<Person> person = new ArrayList<Person>();
		int count = 0;
		while (true) {
			Person p = new Person();
			person.add(p);
			System.out.println(count++);
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
