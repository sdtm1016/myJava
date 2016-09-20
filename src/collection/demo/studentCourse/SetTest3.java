package collection.demo.studentCourse;
import java.util.*;
public class SetTest3 {
	public List<Course> coursesToSelect;
	public Student student;
	private Scanner console;
	public SetTest3(){
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
		System.out.println("请输入课程名称:");
		String name=console.next();
		Course course2=new Course();
		course2.name =name;
		System.out.println("系统收到输入课程："+course2.name);
		System.out.println("备选课程中是否包含课程："+course2.name+","
				+coursesToSelect.contains(course2));
		if(coursesToSelect.contains(course2))
			System.out.println("课程"+course2.name+"的索引位置为"
					+coursesToSelect.indexOf(course2));//indesOf()方法是寻找元素【靠近首部】的索引位置；lastIndesOf()方法是倒序寻找元素【靠近尾部】的索引位置

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest3 st = new SetTest3();
		st.testAdd();
		st.testForEach();
		st.testListContains();
	}

}
