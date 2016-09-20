package collection.demo.studentCourse;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
	public Map<String, Student> students;

	public MapTest() {
		this.students = new HashMap<String, Student>();
	}

	// put(key,value);if(){return/continue;}
	public void testPut() {
		Scanner console = new Scanner(System.in);
		int i = 0;
		while (i < 3) {
			System.out.println("请输入学生id：");
			String ID = console.next();
			Student st = students.get(ID);
			if (st == null) {
				System.out.println("请输入学生姓名：");
				String name = console.next();
				Student newStudent = new Student(ID, name);
				students.put(ID, newStudent);// 添加一对键值对
				System.out.println("成功添加学生：" + students.get(ID).name);
				i++;

			} else {
				System.out.println("该学生已经被占用");
				continue;
			}
		}
	}

	// maplist.keySet();获取所有key返回key集合（Set）
	// maplist.get()
	public void testKeySet() {
		Set<String> keySet = students.keySet();
		System.out.println("总共有：" + students.size() + "个学生！");// 统计键值对数
		for (String stuId : keySet) {
			Student st = students.get(stuId);
			if (st != null)
				System.out.println("学生：" + st.name);
		}
	}

	// remove(key);
	public void testRemove() {
		System.out.println("请输出入要删除的学生ID！");

		while (true) {
			Scanner console = new Scanner(System.in);
			String ID = console.next();
			Student st = students.get(ID);
			if (st == null) {
				System.out.println("该ID不存在");
				continue;
			}
			students.remove(ID);// 删除键对应的一对键值映射
			System.out.println("成功删除学生：" + st.name);
			break;
		}
	}

	// 将Map类转换为Set类。1、keySet(),2、entruSet();
	// Set<Entry<k,v>>;entrySet():获取键值对entry，返回<k,V>集合（set)
	// entry.getkey();entry.getValue();一组键值对entry对应的key,value
	public void testEntrySet() {
		Set<Entry<String, Student>> entrySet = students.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			System.out.println("取得键：" + entry.getKey());
			System.out.println("对应的值为：" + entry.getValue().name);
		}
	}

	public void testModify() {
		System.out.println("请输入要修改的学生ID：");
		Scanner console = new Scanner(System.in);
		while (true) {
			String stuID = console.next();
			Student student = students.get(stuID);
			if (student == null) {
				System.out.println("该ID不存在！请重新输入！");
				continue;
			}
			System.out.println("该学生ID所对应的学生为：" + student.name);
			System.out.println("请输入新的学生姓名：");
			String name = console.next();
			Student newStudent = new Student(stuID, name);
			students.put(stuID, newStudent);// put方法是增加也是修改方法
			System.out.println("修改完成！");
			break;
		}
	}

	public void testContainsKeyOrValue() {
		// 在Map中，用containsKey()方法。来判断是否包含某个key值
		// 而用containsValue()方法，来判断是否包含某个Value值
		System.out.println("请输入要查询的学生ID：");
		Scanner console = new Scanner(System.in);
		String id = console.next();
		System.out.println("您输入的学生ID为：" + id + "在学生映射表中是否存在" + students.containsKey(id));
		if (students.containsKey(id))
			System.out.println("对应的学生的姓名为：" + students.get(id).name);
		System.out.println("请输入要查询的学生姓名：");
		String name = console.next();
		if (students.containsValue(new Student(null, name)))
			System.out.println("在学生映射表中确实包含学生：" + name);
		else
			System.out.println("不包含该学生！");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapTest mt = new MapTest();
		mt.testPut();
		mt.testKeySet();
		// mt.testRemove();
		// mt.testEntrySet();
		// mt.testModify();
		// mt.testEntrySet();
		mt.testContainsKeyOrValue();

	}

}
