package io.byteStream;

import java.io.*;

import io.Util.IOUtil;

public class FIleOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		FileOutputStream out = new FileOutputStream("file/out.dat");
		out.write('A');
		out.write('B');
		int a = 10;
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		byte[] gbk = "gbk".getBytes("gbk");
		out.write(gbk);
		out.close();
		IOUtil.printHex("file/out.dat");

	}

}