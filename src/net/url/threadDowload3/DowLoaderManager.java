package net.url.threadDowload3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

		//本地文件存在
		try {
			// 判断下载文件是否存在
			File file = new File(local);
			if (file.exists()) {
				// 元数据文件是否存在
				File metaFile = new File(local + ".tmp");
				if (metaFile.exists()) {
					this.infos = readDowloadInfosFromFile(metaFile);
				} else {
					//
				}
			}else{
				
			}

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
	 * 从元文件读取下载信息
	 * 
	 * @param metaFile
	 *            元文件
	 * @return 返回下载信息List<DowloadInfo>
	 */

	private List<DowloadInfo> readDowloadInfosFromFile(File metaFile) {
		//
		List<DowloadInfo> infos = new ArrayList<DowloadInfo>();
		try {
			// Java 提供一个Properties类,能够将kv对信息数据存储和读取到一个properties文件中
			// hashtable子类,线程安全
			Properties prop = new Properties();
			prop.load(new FileInputStream(metaFile));
			int count = Integer.parseInt(prop.getProperty("count"));
			DowloadInfo info = null;
			for (int i = 0; i < count; i++) {
				String value = prop.getProperty("thread." + i);
				String[] arr = value.split(":");
				info = new DowloadInfo();
				info.setIndex(i);
				info.setUrl(url);
				info.setStartPos(Integer.parseInt(arr[0]));
				info.setEndPos(Integer.parseInt(arr[1]));
				info.setAmount(Integer.parseInt(arr[2]));
				// 这里的本地文件local和meta数据中local
				String path = metaFile.getAbsolutePath();
				path = path.substring(0, path.lastIndexOf(".tmp"));
				info.setLocal(path);
				infos.add(info);
			}
			return infos;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
