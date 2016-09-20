package io.Util;

import java.io.*;

public class IOUtil {
	// 读取只读文件内容，按照16进制输出到控制台
	// 并且没输出10个字节换行
	public static void printHex(String fileName) throws IOException {
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		while ((b = in.read()) != -1) {
			if (b <= 0xf) {
				// 单位数前面补0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " ");
			if (i++ % 10 == 0) {
				System.out.println();
			}
		}
		in.close();
	}

	// 文件拷贝，进行批量处理
	public static void printHexByByteArray(String fileName) throws IOException {
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];// 20Kb
		// 从in中批量读取字节，放入到buf这个字节数组中，从第0个位置开始放，最多放buf.length个，返回的是读到的字节的个数
		int bytes = 0;
		int j = 1;
		while ((bytes = in.read(buf, 0, buf.length)) != -1) {
			for (int i = 0; i < bytes; i++) {
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
				if (j++ % 10 == 0) {// 循环10次回车
					System.out.println();
				}
			}
		}
		in.close();
	}

	public static void printHexByByteArrayOnce(String fileName) throws IOException {
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];
		int bytes = in.read(buf, 0, buf.length);// 一次性读完，说明字节数组足够大
		int j = 1;
		for (int i = 0; i < bytes; i++) {
			if (buf[i] <= 0xf) {// 15 即:1111,一个byte的最大值
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");// 转换16进制
			if (j++ % 10 == 0) {
				System.out.println();
			}
		}
		in.close();
	}

	public static void copyFile(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件:" + srcFile + "不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[8 * 1024];
		int b;
		while ((b = in.read(buf, 0, buf.length)) != -1) {
			out.write(buf, 0, b);
			out.flush();
		}
		in.close();
		out.close();
	}

	// 进行文件的拷贝，利用带缓冲的字节流
	public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件:" + srcFile + "不存在");

		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		int c;
		while ((c = bis.read()) != -1) {
			bos.write(c);
			bos.flush();// 刷新缓冲区
		}
		bos.close();
		bis.close();
	}

	// 单字节，不带缓冲进行文件拷贝
	public static void copyFileByByte(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件:" + srcFile + "不存在");

		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
			out.flush();
		}
		in.close();
		out.close();
	}

}
