package collection.demo.studentCourse;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	public List<Course> courses;
	public TestGeneric(){
		this.courses=new ArrayList<Course>();
	}
	public void testAdd(){
		Course cr1 =new Course("1","大学语文");
		courses.add(cr1);
		//courses.add("能否添加字符串呢");泛型修饰的集合中，不能添加泛型规定以外的对象，否则会报错！
		Course cr2 =new Course("2","java基础");
		courses.add(cr2);
	}
	public void testForEach(){
		for(Course cr:courses){
			System.out.println(cr.id+"："+cr.name);
		}
	}
	public static void main(String[] args) {
		TestGeneric tg =new TestGeneric();
		tg.testAdd();
		tg.testForEach();
	}
}
