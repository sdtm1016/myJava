package nio.hadoopDemo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

//NIOServerConnection:使用缓冲区
public class NIOServerConnection {
	SocketChannel channel;
	ByteBuffer buffer ;
	SelectionKey key;
	public NIOServerConnection(SelectionKey connkey) {
		this.key = connkey;
		this.channel = (SocketChannel) connkey.channel();
		this.buffer = ByteBuffer.allocate(1024);
	}

	/**
	 * 通过SocketChannel.read()读取数据,
	 * 当read()返回-1时:表明对方管理Socket,那么服务器端也关闭SocketChannel
	 * 否则,设置感兴趣的I/O时间为读/写,
	 * 即SelectionKey.OP_READ和SelectionKey.OP_WRITE
	 * @throws IOException 
	 */
	public void handleRead() throws IOException {
		long bytesRead =channel.read(buffer);
		if(bytesRead == -1){
			channel.close();
		}else{
			key.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);
		}
	}

	/**
	 * 在SocketChannel可写(Socket为什么会不可写,参考相关)的情况下将数据协会客户端
	 * 步骤:通过flip()方法讲缓冲区读模式转为写模式
	 * 然后调用SocketChannle的write()方法写数据
	 * 如果缓冲区中已经没有数据,则设置感兴趣的I/O时间为读:SelectionKey.OP_READ
	 * 最后调用ByteBuffer.compact()方法,一方面讲缓冲区有系恶魔是转换为读模式
	 * 另一方面,为读入数据保留更多空间
	 * @throws IOException 
	 */
	public void handleWriter() throws IOException {
		buffer.flip();
		channel.write(buffer);
		if(!buffer.hasRemaining()){
			key.interestOps(SelectionKey.OP_READ);
		}
		buffer.compact();
	}

}
