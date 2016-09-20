package net.socket.thread;

import java.net.Socket;

import net.socket.thread.demo2.ClientReceive;
import net.socket.thread.demo2.ClientSender;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 12345);
		//new ClientRequest(socket).start();
		new ClientSender(socket).start();
		new ClientReceive(socket).start();
	}
}