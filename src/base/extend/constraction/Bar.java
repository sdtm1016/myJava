package base.extend.constraction;

public class Bar extends Foo {
	int age = 2;
	String name = "lisi";

	Bar() {
		System.out.println("子类的构造方法");
	}

	{
		System.out.println("子类的非静态代码块");
	}
	static {
		System.out.println("子类的静态代码块");
	}

	// 父类中final方法不能被重写，父类protected方法，重写的修饰符要高于父类
	public void po() {
		System.out.println("子类重写e的方法");
	}

	void e2() {
		System.out.println("子类自己的方法");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("主函数开始————————————————————————————————————");
		Bar e2 = new Bar();// 每次new一个对象的时候，父类代码块》父类构造方法》子类代码块》子类构造方法的顺序进行
		e2.fi();
		e2.po();// protected定义的方法可以继承；私有的不能继承
		System.out.println("new子类对象实例化父类——————————————————————————————————");
		Bar e1 = new Bar();// 父类引用子类对象，多态
		// e1.e2();父类通过子类实例化的对象不能调用子类自己声明的方法
		e1.po();// 父类通过子类实例化，父类对象调用方法复写优先于父类
		e1.v();
		System.out.println("new父类对象————————————————————————————————————————————");
		// new Extends1().pr();父类私有的方法，子类无法访问
		new Bar();
	}

}
