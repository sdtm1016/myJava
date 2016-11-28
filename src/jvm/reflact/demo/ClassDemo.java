package jvm.reflact.demo;

/**
 * 万事万物接对象
 * Class.forName("类的全称")
 * 不仅表示了，类的类类型，还代表了动态加载类
 * 区分编译、运行
 * 编译时加载类是静态加载类、运行时刻加载类是动态加载类
 * 4、基本的数据类型
 * 都存在类类型
 */
public class ClassDemo {

	public static void main(String[] args) {
		Class c1 = int.class;// int的类类型
		Class c2 = String.class;// String类的类类型 String类字节码
		Class c3 = double.class;
		Class c4 = Double.class;
		Class c5 = void.class;
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
		System.out.println(c3.getName());
		System.out.println(c4.getName());
		System.out.println(c5.getName());
	}
}
