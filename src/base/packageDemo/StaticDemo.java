package base.packageDemo;

public class StaticDemo {
	{
		System.out.println("非晶态代码块执行");
	}
	static {
		System.out.println("静态代码块");
	}

	public static void main(String[] args) {
		System.out.println("主函数执行");
		System.out.println("创建Text对象");
		Text t = new Text();
	}

}

class Text {
	Text() {
		System.out.println("Text的构造方法");
	}

	{
		System.out.println("Text的非静态代码块");
	}
	static {
		System.out.println("text类中的静态代码块运行");
	}

}