package io.charStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo {

	public static void main(String[] args) {
		String srcFile = "/home/hadoop/test/input/input.txt";
		String targFile = "/home/hadoop/test/output/test.txt";
		FileReader reader = null;
		FileWriter writer = null;
		try {
			reader = new FileReader(srcFile);
			writer = new FileWriter(targFile);
			char[] buf = new char[1024];// 字符流
			int length = 0;
			while ((length = reader.read(buf)) != -1) {
				writer.write(buf, 0, length);
				System.out.println(new String(buf, 0, length));// 字符不用设定 Charset
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
					if (writer != null) {
						writer.close();
					}
				}
				System.out.println("copy over");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}