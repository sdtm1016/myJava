package base.extend.constraction;

public class Foo {
	int age;
	final String name = "zhangsan";// final修饰属性必须初始化
	private double hight;
	{
		System.out.println("父类的非静态代码块");
	}
	static {
		System.out.println("父类的静态代码块");
	}

	public Foo() {
		System.out.println("父类构造方法");
	}

	final void fi() {
		System.out.println("父类的final方法");
	}

	protected void po() {
		System.out.println("父类的保护方法");
	}

	private void pr() {
		System.out.println("父类的私有方法");
	}

	void v() {
		System.out.println("父类的默认方法");
	}

}
