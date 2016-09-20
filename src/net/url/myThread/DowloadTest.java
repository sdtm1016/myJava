package net.url.myThread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DowloadTest {
	public static void main(String[] args) throws IOException {
		String urlStr = "http://mirrors.tuna.tsinghua.edu.cn/apache/hadoop/common/hadoop-3.0.0-alpha1/hadoop-3.0.0-alpha1-src.tar.gz";
		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		FileOutputStream fos = new FileOutputStream("file/hadoop-3.0.0-alpha1-src.tar.gz");
		InputStream is = conn.getInputStream();
		byte[] buf = new byte[1024 * 8];
		int len = 0;
		while ((len = is.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		fos.flush();
		is.close();
		fos.close();
	}
}
