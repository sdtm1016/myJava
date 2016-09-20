package net.socket.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import net.socket.thread.demo1.ServerResponse;

public class Server {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(12345);
		while (true) {
			Socket socket = server.accept();
			System.out.println("Server start..");
			new ServerResponse(socket).start();
		}
	}
}
