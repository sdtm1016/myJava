package io.byteStream;

import java.io.*;

public class ObjectSerdeConstructorDemo {

	public static void write(Object obj) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file/objConstructir.dat"));

		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}

	public static void main(String[] args) throws Exception {

		write(new Foo1());
		write(new Foo2());
		// write(new Bar2());
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file/objConstructir.dat"));

		// 反序列化是否递归调用父类的构造函数
		Foo foo = (Foo) ois.readObject();
		System.out.println(foo);

		// Bar2 bar2 = (Bar2) ois.readObject();
		// System.out.println(bar2);
		ois.close();
	}

}

class Foo implements Serializable {
	public Foo() {
		System.out.println("foo...");
	}
}

class Foo1 extends Foo {
	public Foo1() {
		System.out.println("foo1...");
	}
}

class Foo2 extends Foo1 {
	public Foo2() {

		System.out.println("foo2...");
	}
}

class Bar {
	public Bar() {
	}
}

class Bar1 extends Bar implements Serializable {
	public Bar1() {
		System.out.println("bar1...");
	}
}

class Bar2 extends Bar1 {
	public Bar2() {
		System.out.println("bar2...");
	}
}