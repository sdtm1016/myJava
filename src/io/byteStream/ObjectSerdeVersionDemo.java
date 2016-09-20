package io.byteStream;

import java.io.*;

public class ObjectSerdeVersionDemo {

	public static void write(String file) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

		Student stu = new Student("10001", "张三", 20);
		oos.writeObject(stu);
		oos.flush();
		oos.close();
	}

	public static void main(String[] args) throws Exception {
		String file = "file/student.dat";
		write(file);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Student stu = (Student) ois.readObject();
		System.out.println(stu);
		ois.close();

	}

}
