package net.url.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MergerDemo {
	public static void main(String[] args) throws IOException {
		String name = "hadoop-3.0.0-alpha1-src.tar.gz";
		FileOutputStream fos = new FileOutputStream("file/" + name, true);
		for (int i = 0; i < 4; i++) {
			//RandomAccessFile 
			FileInputStream fis = new FileInputStream("file/" + name + "-" + i);
			byte[] buf = new byte[1024 * 8];
			int len = 0;
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf);
			}
			System.out.println("write file/" + name + "-" + i + " over");
			fis.close();
		}
		fos.close();

	}
}
