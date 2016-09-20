package collection.list;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import collection.javaBean.Student;

public class VectorDemo {

	public static void main(String[] args) {
		Vector<Student> vector = new Vector<Student>(10); // 默认初始容量为10
		Student s = new Student("st1", 11);
		// 将给定的参数对象加入到Vector的原有元素的最后
		vector.addElement(s);
		vector.addElement(new Student("st2", 12));

		// add在index及后续元素向右Shift
		vector.add(1, new Student("st3", 13));

		// 将集合类对象中的所有元素加入到此方法的接收者对象中，如果接收者的结果有变化，则返回true
		// 使用集合col的元素初始化,若果col为数组，需要先将数组转换成为List对象
		List<Student> list = Arrays.asList(new Student("st4", 14), new Student("st4", 12));
		boolean addAll = vector.addAll(list);
		System.out.println("vector.addAll: " + addAll);

		// remove在index及后续元素向左Shift
		// 去除给定位置的元素，并返回被去除的对象
		Student s1 = vector.remove(1);
		// 删除第一次找到的s对象，返回true.找不到则返回false
		boolean removeObj = vector.remove(s);
		System.out.println("vector.remove(s): " + removeObj);
		// 删除所有list中含有的元素
		boolean removeList = vector.removeAll(list);
		System.out.println("vector.removeAll(list): " + removeList);

		// set替换指定位置元素,并返回原元素
		Student s3 = vector.set(0, s1);
		System.out.println("vector.remove(1): " + s1 + "; vector.set(3, s1): " + s3);

		// isEmpty
		if (!vector.isEmpty()) {
			// get(i)返回指定位置的元素
			System.out.println("vector.get(" + vector.size() + "): " + vector.get(vector.size() - 1));
			// 判断Vector是否包含col中的所有元素
			vector.containsAll(list);
			// 判断Vector是否包含obj
			if (vector.contains(s1)) {
				// 返回obj在Vector第一次出现的位置，如果找不到则返回-1
				System.out.println(vector.indexOf(s1));
				// 返回Vector中所有元素的Enumeration对象，注意此方法不能用于ArrayList
				System.out.println(vector.elements());
				// 删除vector的所有元素
				vector.clear();
			}
		}

		String[] arr = { "hello", "world" };
		Vector<String> myVector = new Vector<String>(Arrays.asList(arr));
		System.out.println("myVector: " + myVector);
	}
}