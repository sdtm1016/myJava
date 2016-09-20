package io.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DirCopy {

	public void copyDir(String srcDir, String destDir) {

		File srcFile = new File(srcDir);
		File destFile = new File(destDir);

		// 判断srcFile有效性
		if (srcFile == null || !srcFile.exists()) {
			System.out.println("srcFile 无效!");
			return;
		}
		// 判断destFile有效性
		if (containOrEqu(srcFile, destFile)) {
			System.out.println("destFile 无效!");
			return;
		}
		// 判断destFile是否存在
		if (!destFile.exists()) {
			System.out.println("mkdir " + destFile.getAbsolutePath());
			destFile.mkdirs();// 创建目录
		}

		// 判断srcFile是否是文件
		if (srcFile.isFile()) {
			copyFile(srcFile.getAbsolutePath(), destDir);// E:/b/file
		}

		// 遍历srcFile
		if (srcFile.isDirectory()) {
			String newDestDir = destFile.getAbsolutePath() + "\\" + srcFile.getName();
			// System.out.println(newDestDir);
			destFile = new File(newDestDir);
			if (!destFile.exists()) {
				System.out.println("\tmkdir " + destFile.getName());
				destFile.mkdirs();
			}
			System.out.println("cd " + srcFile);
			for (File child : srcFile.listFiles()) {
				if(child != null){
					if (child.isDirectory()) {
						copyDir(child.getAbsolutePath(), newDestDir);
					} else {// 是文件
						copyFile(child.getAbsolutePath(), newDestDir);
					}
				}

			}
		}
	}

	public void copyFile(String path, String destDir) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		File file = new File(path);
		// 重新规范字符串
		String fileName = file.getName();
		String newPath = file.getAbsolutePath();
		String destPath = new File(destDir).getAbsolutePath();
		try {
			fis = new FileInputStream(newPath);
			// 输出流
			fos = new FileOutputStream(destPath + "\\" + fileName);
			// copy file
			byte[] buf = new byte[1024 * 8];
			int len = 0;
			System.out.println("\tcp " + fileName + " " + destPath);
			while ((len = fis.read(buf)) != -1) {// -1表示流中数据读取完毕
				fos.write(buf, 0, len);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean containOrEqu(File srcFile, File destFile) {
		// 前包含后的情况分析:
		// 1.路径均存在,可能
		// 2.前存在后不存在,可能
		// 3.路径均不存在创建后也有可能
		// 4.前不存在,后存在,即便创建了也觉不会
		// 根据实际情况前不存在无意义,那么排除第3,4条
		if (!srcFile.exists()) {
			return false;
		}
		String destPath = destFile.getAbsolutePath();
		String srcPath = srcFile.getAbsolutePath();
		int dl = destPath.length();
		int sl = srcPath.length();
		// 包含的必要条件:前路径比后路径短
		if ((sl <= dl) && destPath.substring(0, sl).equals(srcPath)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DirCopy app = new DirCopy();
		app.copyDir("E:/test/a/", "E:/test/d");

	}
}
