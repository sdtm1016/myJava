package io.byteStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import io.Util.IOUtil;

public class DataOutputStreamDemo {
	
	public static void main(String[] args) throws IOException {
		String file = "file/raf.txt";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10L);// 8个字节
		dos.writeDouble(10.5);
		dos.writeUTF("中国");
		dos.writeChars("中国");
		dos.close();
		IOUtil.printHex(file);
	}
}
