package nio.hadoopDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 使用选择器在唯一的线程中处理各种I/O请求. 
 * 创建工作与异步的ServerSocketChannel对象, 注册到选择器selector中,
 */
public class NIOServer {
	public static final int PORT = 12312;
	private static final long TIMEOUT = 1000;

	public static void main(String[] args) throws IOException {
		// 1.Create selector,打开一个选择器
		Selector selector = Selector.open();
		
		// 打开一个ServerSocketChannel
		ServerSocketChannel listenChannel = ServerSocketChannel.open();
		listenChannel.configureBlocking(false);// 配置为异步模式
		// 绑定到TCP端口上,注意ServerSocketChannel不提供bind方法
		// 需要使用ServerSocketChannel内部的socket对象对应的bind方法
		listenChannel.socket().bind(new InetSocketAddress(PORT));

		// 2.将listenChannel注册到各种通道,指定每个通道上感兴趣的I/O操作:
		// 通道上有连接请求.即:SelectionKey.OP_ACCEPT
		listenChannel.register(selector, SelectionKey.OP_ACCEPT);// 注册

		// 3.进入服务器循环,调用Selector.select()等待I/O事件.如果返回0表示没有事件
		while (true) {
			// a)调用一种select
			if (selector.select(TIMEOUT) == 0) {
				System.out.print(".");
				continue;
			}
			// 如果select()返回值>0,有I/O事件处理
			// b).获取已选键集
			Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
			while (iter.hasNext()) {// c).对于已选键集中的每一个键
				SelectionKey key = iter.next();
				iter.remove();// i.将已选键从键集中移除
				// ....ii:获取信道,并从键中获取附件(如果需要);

				// iii.确定准备就绪的操作并执行;对于accept操作...
				// 如果时间是"通道上有连接请求"
				if (key.isAcceptable()) {
					// 相应的处理是通过accept()操作获取SocketChannel对象
					SocketChannel channel = listenChannel.accept();
					// 并配置异步工作模式(非阻塞模式),注册到选择器中
					channel.configureBlocking(false);// 配置异步模式
					SelectionKey connkey = channel.register(selector,// 注册
							SelectionKey.OP_READ);
					// 构造连接对象
					NIOServerConnection conn = new NIOServerConnection(connkey);
					connkey.attach(conn);// 连接对象作为SelectionKey对象的附件
				}

				// iv.根据需求,修改键的兴趣操作集
				if (key.isReadable()) {
					NIOServerConnection conn = (NIOServerConnection) key
							.attachment();
					conn.handleRead();// 处理通道上有数据可读
				}
				if (key.isValid() && key.isWritable()) {
					NIOServerConnection conn = (NIOServerConnection) key
							.attachment();
					conn.handleWriter();// 回显,网客户端写数据
				}
			}
		}
	}
}
