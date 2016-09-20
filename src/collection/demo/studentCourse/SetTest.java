package collection.demo.studentCourse;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {
	public List<Course> coursesToSelect;
	public SetTest(){
		coursesToSelect =new ArrayList<Course>();
	}
	public void testAdd(){
		Course cr1= new Course("1","数据结构");
		coursesToSelect.add(cr1);
		Course cr2 =new Course("2","C语言");
		coursesToSelect.add(0, cr2);
		//Course cr3 = new Course("3","test");
		//coursesToSelect.add(4,cr3);
		Course[]course ={new Course("3","离散数学"),new Course("4","汇编语言")};
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest st = new SetTest();
		st.testAdd();
		st.testListContains();
		/*st.testForEach();
		Student stu = new Student("1","小明");
		System.out.println("欢迎选课");
		Scanner console =new Scanner (System.in);
		for (int i=1;i<=3;i++){
			System.out.println("请输入课程ID");
			String courseID =console.next();
			for(Course cr:st.coursesToSelect){
				if(cr.id.equals(courseID)){
					stu.courses.add(cr);
				}
			}
			
		}
		st.testForEachForSet(stu);
	}

	

	public void testForEachForSet(Student stu){
		System.out.println("共选择了"+stu.courses.size()+"门课程");
		for(Course cr : stu.courses){
			System.out.println(cr.id+":"+cr.name);
			
		}*/
		
	}
}