package jvm.reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflect {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		// 获得类描述符
		Class clazz = BigStudent.class;

		// 获得类名称
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		// 获得类定义的方法集合
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			method.getName();
			System.out.println("DeclaredMethod: " + method.getName());
		}

		methods = clazz.getMethods();
		for (Method method : methods) {
			method.getName();
			System.out.println("Method: " + method.getName());
		}

		BigStudent student = new BigStudent();
		// 这里Class实例clazz能够通过类描述符获取类的类型,最终调用相应类的构造函数
		Object o = clazz.newInstance();
		// student.setName("tom")反射方式如下:
		// 通过Class类实例获得setName的方法,这里是Method实例,然后使用invoke反射调用
		Method m = clazz.getMethod("setName", String.class);
		m.invoke(o, "tom");

		// 通过Class类实例获取私有方法不能通过反射调用(私有方法只有类实例可以调用)
		m = clazz.getDeclaredMethod("sayHello", String.class);
		// 强制访问私有方法,如果不设置该参数,将报非法访问异常
		m.setAccessible(true);
		m.invoke(o, "Hello");

		// 获取方法修饰符的总和
		int modifier = m.getModifiers();
		// 这里可以通过Modifier类调用静态方法,如isAbstract判断是否为抽象方法
		// 该方法内部通过该方法实际修饰符modifier与Abstract的16进制进行按位与运算,
		// 这里abstract的16进制为0x00000400其二进制中只有1个位置为1其他全为0,
		// 包括其他所有的修饰符均以此设计,这样设计的结果就是:
		// 1.用于判断是哪个修饰符:如果两个类修饰符不同,两者进行与运算的结果是0, 如果相同,那么他们与运算结果不可能是0
		// 2.用于判断是那些修饰符:如果一个方法有多个修饰符修饰,那么他们会进行安位或运算,
		// 得到如0011之类的,而这个二进制值也是与修饰符组合一一对应的,即可以反过来通过值得知是那些修饰符
		Modifier.isAbstract(modifier);

		// Constructor构造器,参数为构造器的参数类型的类
		Constructor constructor = clazz.getConstructor(int.class);
		Object stu = constructor.newInstance(11);
		System.out.println(stu);
	}
}
