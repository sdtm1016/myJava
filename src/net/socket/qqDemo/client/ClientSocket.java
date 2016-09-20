package net.socket.qqDemo.client;

import java.io.IOException;
import java.net.Socket;

import net.socket.qqDemo.utils.SocketUtil;

//通信类,Controller层,单例
public class ClientSocket {
	public static final String IP = "192.168.0.3";
	public static final int PORT = 12345;
	private static ClientSocket instance;

	public static Socket socket;
	private ReceiverThread receiver;
	private SenderThread sender;

	private ClientSocket(GUI ui) {
		try {
			socket = new Socket(IP, PORT);
			String username = SocketUtil.getHostName().trim() + "-" + socket.getLocalPort();
			sender = new SenderThread(socket, username);
			sender.start();

			// socket附属于MessageClient所以也等同单例
			receiver = new ReceiverThread(socket, ui);
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ClientSocket getInstance(GUI ui) {
		if (instance == null) {
			instance = new ClientSocket(ui);
		}
		return instance;
	}

	public void sendText(String text) {
		sender.setText(text);

	}

	public void close() {
		try {
			// socket.getOutputStream().close();
			// socket.getInputStream().close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}