package jvm.reflact;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		Class clazz = BigStudent.class;

		System.out.println(clazz.getName());

		System.out.println(clazz.getSimpleName());
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
		Object o = clazz.newInstance();// 这里能够获取类的类型

		Method m = clazz.getMethod("setName", String.class);
		m.invoke(o, "tom");

		m = clazz.getDeclaredMethod("sayHello", String.class);
		m.setAccessible(true);// 强制访问私有方法
		m.invoke(o, "Hello");

	}
}
