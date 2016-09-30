package jvm.HeapStack;

/**
 * 从JVM调用的角度分析Java程序对内存空间的使用: 当JVM进程启动的时候,会从类加载路径中找到包含main方法的入口类HelloJVM
 * 找到HelloJVM后会直接读取该文件中的二进制数据,并且把该类的信息放到运行时的Method内存区域中
 * 然后会定位到HelloJVM中的main方法字节码,并开始执行main方法中的指令: Student student = new xxx;
 * 此时会常见Student实例对象并使用student来应用对象(或说对该对象命名),其内幕如下:
 * 第一步:JVM会直接到Method区域中查找Student类的信息,此时发现没有Student类,就通过类加载器加载该Student类文件
 * 第二步:在JVM的Method区域加载并找到了Student类后会在Heap区域中为Student类实例对象分配内存
 * 并在Student的实例对象中持有指向方法区域中的Student类的应用(内存地址);
 * 第三步:JVM实例化完成后,会在当前线程中为Stack中的reference建立实际的应用关系,此时会赋值给student
 * 
 * 在JVM中方法的调用一定是属于线程的行为,也就是说方法调用会发生在调用线程的方法调用栈: 线程的方法调用栈(Method Stack
 * Frames),每一个方法的调用就是方法调用栈中的一个Frame, 该Frame包含了方法的参数,局部变量,临时数据等;
 * student.sayHello();
 * 其他参考:http://www.cnblogs.com/zhguang/p/3154584.html
 */
public class HelloJVM {
	/**
	 * 在JVM运行的时候会通过反射的方式到Method区域找到入口类方法main
	 */
	public static void main(String[] args) {// main在Method方法区域
		/**
		 * student是放在主线程Stack区域;Student对象实例放在所有线程共享的Heap区域
		 */
		Student student = new Student("student");
		/**
		 * 首先会通过student指针(句柄)找Student对象,当找到该对象后,会通过对象内部指向方法区域中的指针来调用具体的方法执行
		 */
		student.sayHello();
	}

}

class Student {
	// name本身为成员,放在Stack区域,但name指向的String对象放在Heap中
	private String name;

	public Student(String name) {
		this.setName(name);
	}

	// sayHello这个方法是放在方法区域中的
	public void sayHello() {
		System.out.println("Hello, this is " + this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}