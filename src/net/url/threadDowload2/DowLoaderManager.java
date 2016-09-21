package net.url.threadDowload2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 下载管理器
 * 
 * @author Noah
 *
 */
public class DowLoaderManager {
	private String url;
	private String local;
	private int count;
	private int totalLength;
	private List<DowloadInfo> infos;
	private UI ui;

	public List<DowloadInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<DowloadInfo> infos) {
		this.infos = infos;
	}

	public DowLoaderManager(String url, String local, int count, UI ui) {
		this.ui = ui;
		this.url = url;
		this.local = local;
		this.count = count;

		// 准备下载
		prepareDowload();
	}

	/**
	 * 准备下载 1.提取url文件 2.创建本地文件 3.准备dowloadInfo集合(每个线程下载的信息)
	 */
	public void prepareDowload() {
		infos = new ArrayList<DowloadInfo>();

		try {
			// 1.提取文件大小
			URL url0 = new URL(url);
			this.totalLength = url0.openConnection().getContentLength();
			// 1.1
			if (totalLength < 0) {
				System.err.println("无效路径,或网络连接异常");
				return;
			}

			// 2.创建本地文件
			RandomAccessFile raf = new RandomAccessFile(local, "rw");
			raf.setLength(totalLength);
			raf.close();

			// 3.准备dowload集合
			int block = totalLength % count == 0 ? totalLength / count : totalLength / count + 1;
			DowloadInfo info;
			for (int i = 0; i < count; i++) {
				info = new DowloadInfo();
				info.setUrl(url);
				info.setLocal(local);
				info.setStartPos(i * block);
				if (i == (count - 1)) {
					info.setEndPos(totalLength - 1);
				} else {
					info.setEndPos((i + 1) * block - 1);
				}
				info.setIndex(i);
				infos.add(info);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 开始下载
	 */
	public void start() {
		for (DowloadInfo info : infos) {
			new DowloadThread(info, ui).start();
		}
	}
}
