package jvm.reflact.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 打印类的信息，包括类的成员函数、成员变量
 * 
 * @param obj
 *            该对象所属类的信息
 */
public class ClassUtil {

	/**
	 * 获取成员函数的信息(public)
	 * 
	 * @param obj
	 */
	public static void printClassMethodMessage(Object obj) {
		// 要获取类的信息，首先要获取类的类类型
		Class c = obj.getClass();// 传递的是哪个子类的对象，c就是该子类的类类型
		// 获取类的名称
		System.out.println("类的名称是：" + c.getName());
		/*
		 * Method类，方法对象 一个成员方法就是一个Method对象
		 * getMethods()方法获取的是所有public的函数，包括父类继承而来的
		 * getDeclardeMethods()获取是所有该类自己声明的方法，不问访问权限
		 */
		Method[] ms = c.getMethods();
		// Method[] ms = c.getDeclaredMethods();
		for (int i = 0; i < ms.length; i++) {
			// 得到方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			// 得到方法的名称
			System.out.print(ms[i].getName() + "(");
			// 获取参数类型--->得到的是参数列表的类型的类类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");

			}
			System.out.println(")");
		}

	}

	/**
	 * 获取成员变量的信息
	 * 
	 * @param obj
	 */
	public static void printFieldMessage(Object obj) {
		Class c = obj.getClass();
		/*
		 * 成员变量也是对象 java.lang.reflect.Field Field类封装了关于成员变量的草错
		 * getFilds（）方法获取的是所有的public的成员变量的信息 getDeclaredFields获取的是该类自己声明的成员变量的信息
		 */
		// Field[] fs = c.getFields()
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			// 得到成员变量的类型的类类型
			Class fieldType = field.getType();
			String fieleName = field.getName();
			System.out.println(fieldType + " " + fieleName);
		}
	}

	/**
	 * 打印对象的构造函数的信息
	 * 
	 * @param obj
	 */
	public static void printConMessage(Object obj) {
		Class c = obj.getClass();
		/*
		 * 构造函数也是对象 java.long.Constructor 中封装了构造函数的信息 getConstructors
		 * 获取所有的public 的构造函数 getDeclardeConstructors 得到所有的构造函数
		 */
		// Constructor[] s = c.getDeclaredConstructors();
		Constructor[] s = c.getConstructors();
		for (Constructor constructor : s) {
			System.out.print(c.getName() + "(");
			// 获取构造函数的参数列表---->得到的是参数类型的类类型
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
	}
}
