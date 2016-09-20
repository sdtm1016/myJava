package io.Util;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	public static void listDirectory(File dir) throws IOException {
		if (!dir.exists()) {
			throw new IllegalArgumentException("dir：" + dir + " not exist");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "is not dir");
		}

		String[] filenames = dir.list();// 返回的是字符串数组，直接子的名称，不包含子目录下的文件
		for (String string : filenames) {
			System.out.println(dir + "\\" + string);
		}
		// 如果要遍历子目录下的内容就需要构造成File对象做递归操作，File提供了直接返回Flie对象的API
		File[] files = dir.listFiles();// 返回的是直接子目录（文件）的抽象

		// for (File file : files) {System.out.println(file);}

		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					// 递归
					listDirectory(file);
				} else {
					System.out.println(file);
				}
			}
		}
	}

}