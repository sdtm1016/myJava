package io.charStream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			// true表示追加,默认false即覆盖
			fw = new FileWriter("/home/hadoop/test/output/test.txt", true);
			//fw = new FileWriter("E:\\Workspaces\\FileOutput\\test.txt", true);
			fw.write("hello world \r\n");
			fw.write("how are you?\r\n");
			fw.write("你好吗?");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}