package io.file;

import java.io.*;

/**
 * 将file目录下的所有.java文件复制到target\jad目录下，并将原来文件的扩展名从.java改为.jad。
 */
public class Jad2Java {
	public static void main(String[] args) throws Exception {
		File srcDir = new File("file");
		if (!(srcDir.exists() && srcDir.isDirectory()))
			throw new Exception("目录不存在");
		File[] files = srcDir.listFiles(
				new FilenameFilter() {
					//只得到.java的文件
					public boolean accept(File dir, String name) {
						return name.endsWith(".java");
					}
				}
		);

		System.out.println(files.length);
		File destDir = new File("target/jad");
		if (!destDir.exists()) destDir.mkdir();
		for (File f : files) {
			FileInputStream fis = new FileInputStream(f);
			//根据源文件名得到目标文件名，注意要用正则表达式，注意.的转义。
			String destFileName = f.getName().replaceAll("\\.java$", ".jad");
			FileOutputStream fos = new FileOutputStream(new File(destDir, destFileName));
			copy(fis, fos);
			fis.close();
			fos.close();
		}
	}

	/**
	 * 拷贝方法独立成为一个方法，
	 * 方法接受的参数类型尽量面向父类，越抽象越好，这样适应面更宽广
	 */
	private static void copy(InputStream ips, OutputStream ops) throws Exception {
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = ips.read(buf)) != -1) {
			ops.write(buf, 0, len);
		}
	}
}
