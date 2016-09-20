package io.byteStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerdeGraphCopy {

	public static void main(String[] args) throws Exception {
		// 比较两个对象中的NotSer是否一样
		copy();
		// 这里在反序列化的时候,会重新对包含的NotSer实例加载,这将会是一个新的对象
		deepCopy();
	}

	// 对象图的浅度复制
	public static void copy() {
		NotSer notser = new NotSer("");
		Ser ser1 = new Ser("ser1", notser);
		// 浅度复制,ser2与ser1中包含的对象相同
		Ser ser2 = new Ser(ser1.getSer(), ser1.getNotSer());
		System.out.println("ser1: " + ser1.getNotSer());
		System.out.println("ser2: " + ser2.getNotSer());
	}

	// 深度复制
	// 这里ser2中的NotSer对象将与ser1的不同,仅仅是复制了对象图
	public static void deepCopy() throws Exception {
		NotSer notser = new NotSer("");
		Ser ser1 = new Ser("ser1", notser);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(ser1);
		oos.close();
		baos.close();
		byte[] bytes = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Ser ser2 = (Ser) ois.readObject();
		ois.close();
		bais.close();
		System.out.println("ser1: " + ser1.getNotSer());
		System.out.println("ser2: " + ser2.getNotSer());

	}
}
