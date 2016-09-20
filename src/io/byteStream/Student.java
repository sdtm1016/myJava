package io.byteStream;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 5106260069682825792L;
	private String stuno;
	private String Stuname;
	private transient int stuage;// 该元素不会进行jvm的序列号,如果必须对其序列化反序列化,可自己实现

	public Student() {
	}

	public Student(String stuno, String stuname, int stuage) {
		super();
		this.stuno = stuno;
		Stuname = stuname;
		this.stuage = stuage;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getStuname() {
		return Stuname;
	}

	public void setStuname(String stuname) {
		Stuname = stuname;
	}

	public int getStuage() {
		return stuage;
	}

	public void setStuage(int stuage) {
		this.stuage = stuage;
	}

	@Override
	public String toString() {
		return "Student [stuno=" + stuno + ", Stuname=" + Stuname + ", stuage=" + stuage + "]";
	}

	private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
		s.defaultWriteObject();// 把jvm能默认的序列化的元素进行序列化操作
		s.writeInt(stuage);// 自己完成stuage的序列化
	}

	private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();// 把jvm能默认反序列化的元素进行反序列化操作
		this.stuage = s.readInt();// 自己完成stuage的反序列化操作
	}

}
