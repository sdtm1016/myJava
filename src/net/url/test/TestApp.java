package net.url.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestApp {

	public static void main(String[] args) throws IOException {
		// 安装tomcat,在root目录下放一个文件
		// 如:D:\Program
		// Files\apache-tomcat-6.0.45\webapps\ROOT\lantern-installer-beta.exe
		String urlStr = "http://localhost:8000/lantern-installer-beta.exe";
		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		String type = conn.getContentType();
		int length = conn.getContentLength();
		System.out.println(type + " : " + length);
		InputStream is = conn.getInputStream();
		FileOutputStream fos = new FileOutputStream("file/lantern-installer-beta.exe");
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = is.read(buf)) != -1) {
			fos.write(buf);
		}
		fos.close();
		is.close();

	}
}
