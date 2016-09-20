package nio.selector;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Demo {
	static SocketChannel channel;
	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		channel.configureBlocking(false);
		SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0)
				continue;
			Set selectedKeys = selector.selectedKeys();
			Iterator keyIterator = selectedKeys.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey k = (SelectionKey) keyIterator.next();
				if (k.isAcceptable()) {
					// a connection was accepted by a ServerSocketChannel.
				} else if (k.isConnectable()) {
					// a connection was established with a remote server.
				} else if (k.isReadable()) {
					// a channel is ready for reading
				} else if (k.isWritable()) {
					// a channel is ready for writing
				}
				keyIterator.remove();
			}
		}
	}
}
