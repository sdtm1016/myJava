package net.url.myThread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DowloadDemo {
	public static void main(String[] args) throws IOException {
		String urlStr = "http://mirrors.tuna.tsinghua.edu.cn/apache/hadoop/common/hadoop-3.0.0-alpha1/hadoop-3.0.0-alpha1-src.tar.gz";
		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		long len = conn.getContentLength();
		conn.getContentType();
		conn.getContent().getClass();
		String name = urlStr.substring(urlStr.lastIndexOf("/"));
		if (len % 3 != 0) {
			for (int i = 0; i <= 3; i++) {
				DowloadThread dowload = new DowloadThread(len, url);
				dowload.setName(name + "-" + i);
				dowload.start();
			}
		} else {
			for (int i = 0; i <= 2; i++) {
				DowloadThread dowload = new DowloadThread(len, url);
				dowload.setName(name + "-" + i);
				dowload.start();
			}
		}

	}

	static class DowloadThread extends Thread {
		private URLConnection conn;
		long len = 0;
		private URL url;

		public DowloadThread(long len, URL url) {
			this.len = len;
			this.url = url;
		}

		@Override
		public void run() {
			try {
				URLConnection conn = url.openConnection();
				String name = Thread.currentThread().getName();
				int i = Integer.valueOf(name.substring(name.length() - 1));
				long length = len / 3;

				long start = length * i;
				long end = length * (i + 1) - 1;

				if (i == 3) {
					end = len - 1;
				}

				String value = "bytes=" + start + "-" + end;
				// set要在get之前,如果get了就自动链接了服务器,打开了输入流
				// range 0-xx
				// conn.setRequestProperty("Range", "bytes=xxx-xxx");
				System.out.println(null == conn);
				conn.setRequestProperty("Range", value);
				InputStream is = conn.getInputStream();
				FileOutputStream fos = new FileOutputStream("file/" + name);
				byte[] buf = new byte[1024 * 8];
				int len = 0;
				while ((len = is.read(buf)) != -1) {
					fos.write(buf, 0, len);
					System.out.println(name + " write 8kb");
				}
				fos.flush();
				is.close();
				fos.close();
				System.out.println(name + "----------------over---------");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
