package io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("E:\\Workspaces\\FileInput");// 双
		System.out.println("file.exists(): " + file.exists());
		if (!file.exists())
			file.mkdir();
		else
			file.delete();
		System.out.println("file.isDirectory(): " + file.isDirectory());
		System.out.println("file.isFile(): " + file.isFile());

		File file2 = new File("E:\\Workspaces\\FileInput\\gb2312.txt");
		if (!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			file2.delete();
		System.out.println("file: " + file);
		System.out.println("file.length(): " + file.length());
		System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
		System.out.println("file.getName(): " + file.getName());
		System.out.println("file.getParentFile(): " + file.getParentFile());
		System.out.println("file2.getParentFile().getAbsolutePath(): " + file2.getParentFile().getAbsolutePath());

		// 重命名,可以跨磁盘(包含移动),但是不支持跨文件系统平台
		boolean rename = new File("E:\\Workspaces\\FileInput\\gb2312.txt")
				.renameTo(new File("E:\\Workspaces\\FileInput\\GB2312.txt"));
		System.out.println("rename: " + rename);
	}
}
