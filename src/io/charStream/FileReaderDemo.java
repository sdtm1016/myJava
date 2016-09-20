package io.charStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			//fr = new FileReader("E:\\Workspaces\\FileOutput\\test.txt");
			//fr = new FileReader("E:/Workspaces/FileInput/gb2312.txt");
			fr = new FileReader("/home/hadoop/test/input/input.txt");
			char[] buf = new char[1024];// 字符流用char数组
			int length = 0;

			while ((length = fr.read(buf)) != -1) {// -1表示流已经写完,在每次循环中做输出
				System.out.println(new String(buf, 0, length));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}