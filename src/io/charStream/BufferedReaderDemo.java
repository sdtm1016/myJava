package io.charStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

public class BufferedReaderDemo {
	String line = null;

	public void bufReader() throws IOException {
		BufferedReader bufReader = new BufferedReader(new FileReader("E:/Workspaces/FileInput/readLineText.txt"));
		// readLine将读取一行,一行的定义:以\n还可以伴随\r结束为标准,读取返回的字符串不包含换行符
		while ((line = bufReader.readLine()) != null) {
			System.out.print(line + ";");
		}
		System.out.println();
	}

	public void lineReader() throws IOException {
		LineNumberReader lineNumReader = new LineNumberReader(
				new FileReader("E:/Workspaces/FileInput/readLineText.txt"));
		while ((line = lineNumReader.readLine()) != null) {
			int lineNum = lineNumReader.getLineNumber();
			System.out.println(lineNum + "." + line);
		}
	}

	// 测试时间
	public void testReader(Reader read) throws IOException {
		// 循环读取
		long start = System.currentTimeMillis();
		while (read.read() != -1) {
		}
		long end = System.currentTimeMillis();
		System.out.println(read.getClass().getSimpleName() + "time:" + (end - start));
		read.close();
	}

	public void testMark(Reader read) throws IOException {
		int c;
		while ((c = read.read()) != -1) {
			System.out.println((char) c);
		}
		read.mark(0);
		read.reset();
		while ((c = read.read()) != -1) {
			System.out.println(c);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReaderDemo demo = new BufferedReaderDemo();
		String src = "E:/Workspaces/FileInput/123Mb.txt";
		// demo.bufReader();
		// demo.lineReader();
		// 非缓冲区
		FileReader fileReader = new FileReader(src);
		// 缓冲区
		BufferedReader bufReader = new BufferedReader(new FileReader(src), 1024 << 3);// 这里不能引用fileReader
		demo.testReader(fileReader);// 5186
		demo.testReader(bufReader);// 3136

	}
}
