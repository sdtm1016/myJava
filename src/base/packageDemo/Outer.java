package base.packageDemo;

public class Outer {
	int age = 1;
	static int num = 2;
	private String name;

	class Inner {
		int age = 2;
		// static int n =3;非静态内部类不能生命静态静态成员和方法
		String add;

		void f() {
			// 方法内部调用外部成员，静态，私有，同名的时候
			System.out.println(age + "," + Outer.this.age + "," + num + "," + name);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		// 内部类外部调用内部类的成员
		in.f();

	}

}
