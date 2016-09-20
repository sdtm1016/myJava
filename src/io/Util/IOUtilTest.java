package io.Util;

import java.io.File;
import java.io.IOException;

public class IOUtilTest {

	public void test1() {
		try {
			IOUtil.printHex("D:\\Test\\test.java");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void test2() {
		try {
			long start = System.currentTimeMillis();// 当前时间与1970年相差的毫秒数
			// IOUtil.printHexByByteArray("D:\\Test\\test.java");
			// IOUtil.printHex("D:\\Test\\java.pdf");
			IOUtil.printHexByByteArray("D:\\Test\\java.pdf");
			System.out.println();
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void test3() {
		try {
			IOUtil.copyFile(new File("D:\\Test\\test.txt"), new File("D:\\Test\\test1.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test4() {
		try {
			long start = System.currentTimeMillis();
			IOUtil.copyFile(new File("D:\\Test\\java.pdf"), new File("D:\\Test\\1.pdf"));
			// IOUtil.copyFileByBuffer(new File("D:\\Test\\java.pdf"), new
			// File("D:\\Test\\2.pdf"));
			// IOUtil.copyFileByByte(new File("D:\\Test\\java.pdf"), new
			// File("D:\\Test\\3.pdf"));
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
