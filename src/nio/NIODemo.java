package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {
	/**
	 * 使用IO读取指定文件的前1024个字节的内容。
	 */
	public void ioRead(String file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		byte[] b = new byte[1024];
		in.read(b);
		System.out.println(new String(b));
	}

	/**
	 * 使用NIO读取指定文件的前1024个字节的内容。
	 */
	public void nioRead(String file) throws IOException {
		// 第一步是获取通道。我们从 FileInputStream 获取通道：
		FileInputStream in = new FileInputStream(file);
		FileChannel channel = in.getChannel();
		// 下一步是创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// 最后，需要将数据从通道读到缓冲区中：
		channel.read(buffer);
		byte[] b = buffer.array();
		System.out.println(new String(b));
	}

	public void nioWriter(String file) throws IOException {
		// 首先从 FileOutputStream 获取一个通道：
		FileOutputStream fout = new FileOutputStream("writesomebytes.txt");
		FileChannel fc = fout.getChannel();
		// 下一步是创建一个缓冲区并在其中放入一些数据，这里，用message来表示一个持有数据的数组。
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		// TODO code message
		byte[] message = null;// message
		for (int i = 0; i < message.length; ++i) {
			buffer.put(message[i]);
		}
		buffer.flip();
		// 最后一步是写入缓冲区中：
		fc.write(buffer);
	}

	public static void main(String[] args) throws IOException {

	}
}
