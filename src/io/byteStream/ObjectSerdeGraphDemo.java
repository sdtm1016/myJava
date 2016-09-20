package io.byteStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerdeGraphDemo {
	public static void write(Object obj) throws Exception {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file/objGrap.dat"));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}

	

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		write(new Ser("ser"));
		// write(new Ser("ser", new NotSer("notSer")));
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file/objGrap.dat"));
		Ser ser = (Ser) ois.readObject();
		System.out.println(ser.ser);
		// System.out.println(ser.notSer.notSer);

	}
}

class Ser implements Serializable {
	private static final long serialVersionUID = -8549070247223143958L;
	String ser;
	NotSer notSer;

	public String getSer() {
		return ser;
	}

	public void setSer(String ser) {
		this.ser = ser;
	}

	public NotSer getNotSer() {
		return notSer;
	}

	public void setNotSer(NotSer notSer) {
		this.notSer = notSer;
	}

	public Ser(String ser) {
		this.ser = ser;
	}

	public Ser(String ser, NotSer notSer) {
		this.ser = ser;
		this.notSer = notSer;
	}
}

class NotSer implements Serializable {
	private static final long serialVersionUID = 2353985024281665799L;
	String notSer;

	public String getNotSer() {
		return notSer;
	}

	public void setNotSer(String notSer) {
		this.notSer = notSer;
	}

	public NotSer(String notSer) {
		this.notSer = notSer;
	}

}