package io.byteStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {

	public static void main(String[] args) throws IOException {

		// 写入
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// write对int转会为char,保存在buf中,并count++
		baos.write(100);
		baos.write('s');
		baos.write(256);// 转换后为0,空格
		byte[] bytes = baos.toByteArray();
		baos.write(bytes);
		baos.close();
		System.out.println(baos.toString());

		// 读取
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		// read读取下一个字节返回,范围(0-255),返回-1表示结尾
		// 通过&运算 & 0xff,清空高24位数据
		// bais.read();
		int i = 0;
		while ((i = bais.read()) != -1) {
			System.out.println(i);
		}
	}
}
