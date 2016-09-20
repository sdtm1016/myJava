package net.url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	public static void main(String[] args) throws IOException {
		String urlStr = "http://www.baidu.com";
		URL url = new URL(urlStr);
		
		url.getHost();
		System.out.println("url.getProtocol(): " + url.getHost());
		// 打开连接
		URLConnection conn = url.openConnection();
		
		//String type = conn.getContentType();
		//long length = conn.getContentLengthLong();
		//String encode = conn.getContentEncoding();
		//Object content = conn.getContent();
		// System.out.println(content);
		
		
		InputStream is = conn.getInputStream();
		FileOutputStream fos = new FileOutputStream("file/baidu.html");
		byte[] buf = new byte[1024];
		int len = 0;

		while ((len = is.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		fos.close();
		is.close();
	}
}
