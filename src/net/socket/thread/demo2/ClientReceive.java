package net.socket.thread.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceive extends Thread {
	Socket socket;
	BufferedReader is;

	public ClientReceive(Socket socket) {
		try {
			is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		try {
			while (true) {
				String line = is.readLine();
				System.out.println("ClientReceive :" + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
