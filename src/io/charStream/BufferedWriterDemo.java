package io.charStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedWriterDemo {

	static char[] buf;
	static {
		buf = new char[8192];
		for (int i = 0; i < buf.length; i++) {
			buf[i] = 'a';
		}
	}

	public static void main(String[] args) throws IOException {
		// myWriter();

		// 非缓冲
		FileWriter writer = new FileWriter("E:/Workspaces/FileOutput/fileWriter.txt");
		// 缓冲,速度与每次写入的量,设置缓冲区size均有关
		BufferedWriter bufWriter = new BufferedWriter(new FileWriter("E:/Workspaces/FileOutput/bufWriter.txt"),
				1024 << 3);// 默认1024 * 8

		// 测试FileWriter
		int max = 10000000;// string:129Mb,buf不可测试
		// max = 1000000;//string
		// max = 10000;
		// max = 1000;//测试buf
		long start = System.currentTimeMillis();
		for (int i = 0; i < max; i++) {
			writer.write("hello world~ ");// 910,140,50
			// writer.write(buf);//39400,350,50
		}
		writer.close();
		long end = System.currentTimeMillis();
		System.out.println("FileWriter time :" + (end - start));

		// 测试BufferedWriter
		start = System.currentTimeMillis();
		for (int i = 0; i < max; i++) {
			bufWriter.write("hello world~ ");// 590,70,30
			// bufWriter.write(buf);//50350,320,30
		}
		bufWriter.close();
		end = System.currentTimeMillis();
		System.out.println("BufferedWriter time :" + (end - start));
	}

	public static void myWriter() throws IOException {
		// PrintWriter和BufferedWriter均是对Writer封装
		PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter("E:/Workspaces/FileOutput/myPrintWriter.txt")));
		// PrintWriter对象是System.out中out的对象,默认输出控制台
		// 这里通过自定义对Writer封装后实现的out,将输出到一个指定的文件中
		out.println("hello world");
		out.close();
	}

}
