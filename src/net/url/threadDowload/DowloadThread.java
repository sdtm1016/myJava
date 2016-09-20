package net.url.threadDowload;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 下载线程
 * 
 * @author Noah
 *
 */
public class DowloadThread extends Thread {
	private DowloadInfo info;
	private UI ui;

	public DowloadThread(DowloadInfo info, UI ui) {
		this.ui = ui;
		this.info = info;
	}

	@Override
	public void run() {
		try {
			URL url = new URL(info.getUrl());
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Range", "bytes=" + info.getStartPos() + "-" + info.getEndPos());
			// 获取流
			InputStream is = conn.getInputStream();
			// 定位本地文件
			RandomAccessFile raf = new RandomAccessFile(info.getLocal(), "rw");
			raf.seek(info.getStartPos());

			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = is.read(buf)) != -1) {

				// 暂停
				while (ui.isPausing) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				raf.write(buf, 0, len);
				ui.updataProcessBar(len);
			}
			raf.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
