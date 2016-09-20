package base.packageDemo;

public class OutStatic {
	static int i=0;
	char a='x';
	static class Inner{
		int age=i;//静态内部类可以直接访问外部类的静态成员
		static String name="zhangsan";
		
		//char ina=a;静态内部类不能使用内部类外非静态变量；需要用外部对象调用来使用
		char ina=new OutStatic().a;
		OutStatic o=new OutStatic();
		char innera=o.a;
		static void s(){
			System.out.println("静态内部类的静态方法"+i);
		}
		void v(){
			System.out.println("静态内部非静态方法");
		}
	}
	public static void main(String[] args) {
		OutStatic out =new OutStatic ();
		Inner in =new Inner();//可以直接实例化静态内部类
		System.out.println(Inner.name);
		System.out.println(new Inner().age);
		Inner.s();//静态内部类的静态方法可以用内部类直接调用
		new Inner().v();//静态内部类的非静态方法需要实例化内部类调用	
	}

}
