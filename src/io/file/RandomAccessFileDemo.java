package io.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileDemo {
	public static File getFile(String file) throws IOException {
		File demo = new File("file");
		if (!demo.exists())
			demo.mkdirs();
		File f = new File(demo, file);
		if (!f.exists())
			f.createNewFile();
		return f;
	}

	public static void main(String[] args) throws Exception {

		RandomAccessFile raf = new RandomAccessFile(getFile("randomAccessFile.txt"), "rw");
		// Demo
		// write(raf);
		//read(raf);
		readStream(raf);
		// raf(raf);
	}


	public static void write(RandomAccessFile raf) throws IOException {
		// 指针的位置point=0；
		System.out.println("FilePointer:" + raf.getFilePointer());
		raf.write('A');
		System.out.println("FilePointer:" + raf.getFilePointer());
		raf.write('B');
		System.out.println("FilePointer:" + raf.getFilePointer());

		int i = 0x7fffffff;
		// 用write方法每次只能写一个字节，如果要把i写进去就得写4次
		raf.write(i >>> 24);
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		System.out.println("FilePointer:" + raf.getFilePointer());
		// 可以直接写一个int
		raf.writeInt(i);// 4个字节

		String s = "中";// 2个字节,java的utf—16be编码
		byte[] gbk = s.getBytes("utf-8");
		raf.write(gbk);
		System.out.println("raf.length(): " + raf.length());

	}

	public static void read(RandomAccessFile raf) throws IOException {
		// 读文件，须把指针移动到头部
		raf.seek(0);
		byte[] buf = new byte[(int) raf.length()];
		raf.read(buf);

		System.out.println(Arrays.toString(buf));
		String s1 = new String(buf);
		// String s1 = new String(buf, "GBK");
		System.out.println(s1);
		for (byte b : buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		raf.close();
	}

	public static void readStream(RandomAccessFile raf) throws Exception {

		byte[] buf = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		raf.seek(0);
		int len = 0;
		while ((len = raf.read(buf)) != -1) {
			baos.write(buf, 0, len);
		}
		raf.close();
		baos.close();

		String str = new String(baos.toByteArray(), "utf-8");
		System.out.println(str);
	}

}
