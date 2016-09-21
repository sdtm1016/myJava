package jvm.reflact.demo;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 * 3)为什么要用方法的反射
 * why？指定方法名称调用方法
 * 举个实际应用的案例--->通过标准的JavaBean的属性名获取器属性值
 * BeanUtil类
 * 4)通过Class，Method来认识泛型的本质
 */
public class MethodDemo4 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Hello");
		// list1.add(1);泛型防止添加规定的类型外的类型
		Class c1 = list.getClass();
		Class c2 = list1.getClass();
		System.out.println(c1 == c2);
		// 反射的操作都是编译之后的操作

		/*
		 * c1==c2 结果返回true说明 编译之后集合的泛型是去泛型化 Java中集合的泛型，是泛指错误输入的，只在编译阶段有效，
		 * 绕过编译就无效了 验证：我们可以通过方法的反射来操作，绕过编译
		 */
		try {
			Method m = c1.getMethod("add", Object.class);
			m.invoke(list1, 100);// 绕过了编译操作 ，就绕过了泛型！！！
			System.out.println(list1.size());
			System.out.println(list1);
			// 现在就不能用foreach遍历了，因为此时类型有int类型
			/*
			 * for (String string : list1) { System.out.println(string); }
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
