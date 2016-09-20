package io.byteStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("D:\\Test\\test.txt");

		InputStreamReader isr = new InputStreamReader(in);// 默认的项目编码，java都是jbk，如果一个文件是utf-8，要在参数内添加编码方式
		/*
		 * int c; while((c=isr.read())!=-1){ System.out.print((char)c); }
		 */
		char[] buffer = new char[8 * 1024];
		int c;
		while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
			String s = new String(buffer, 0, c);
			System.out.println(s);
		}
	}
}
