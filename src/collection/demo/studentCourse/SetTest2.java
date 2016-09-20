package collection.demo.studentCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest2 {
	public List<Course> coursesToSelect;
	public Student student;
	private Scanner console;
	public SetTest2(){
		coursesToSelect =new ArrayList<Course>();
		console =new Scanner(System.in);
	}
	
	
	public void testAdd(){
		Course[]course ={new Course("1","数据结构"),new Course("2","C语言"),new Course("3","离散数学"),new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));		
		Course[] course2={new Course("5","高等数学"),new Course("6","大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));	
	}
	
	public void testForEach(){
		System.out.println("有如下课程：");
		for(Course cr:coursesToSelect){
			System.out.println("课程："+cr.id+":"+cr.name);
		}
	}
	public void testListContains(){
		Course course=coursesToSelect.get(0);
		System.out.println("取得课程："+course.name);//判断序列中是否包含名称为name的元素，contains调用了Object的equals()方法
		System.out.println("备选课程中是否包含课程："+course.name+","+
		coursesToSelect.contains(course));
		
		System.out.println("请输入课程名称:");
		Scanner console=new Scanner(System.in);
		String name=console.next();
		Course course2=new Course();
		course2.name =name;
		System.out.println("系统收到输入课程："+course2.name);
		System.out.println("备选课程中是否包含课程："+course2.name+","
				+coursesToSelect.contains(course2));
		
		/*//添加一个和序列中相同的课程。判断序列中是否包含该新课程
		Course course2 = new Course(course.id,course.name);
		System.out.println("新建课程"+course2.name);
		System.out.println("备选课程中是否包含课程："+course2.name+","+
		coursesToSelect.contains(course2));*/			
	}
	public void testSetContains(){
		System.out.println("请输入学生已选的课程名称：");
		String name =console.next();
		Course course=new Course();
		course.name =name;
		System.out.println("系统收到输入课程："+course.name);
		System.out.println("备选课程中是否包含课程："+course.name+","
				+student.courses.contains(course));
		
	}
	public void createStudentAndSelectCous(){
		student = new Student("1","小明");
		System.out.println("欢迎选课");
		Scanner console =new Scanner (System.in);
		for (int i=1;i<=3;i++){
			System.out.println("请输入课程ID");
			String courseID =console.next();
			for(Course cr:coursesToSelect){
				if(cr.id.equals(courseID)){
					student.courses.add(cr);
				}
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest2 st = new SetTest2();
		st.testAdd();
		st.testForEach();
		st.createStudentAndSelectCous();
		st.testSetContains();
		
	}
}