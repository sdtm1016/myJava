package net.socket.thread.demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceive extends Thread {
	Socket socket;
	BufferedReader br;

	public ClientReceive(Socket socket) {
		try {
			this.socket = socket;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "gbk"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		try {
			while (true) {
				String line = br.readLine();
				System.out.println("ClientReceive: " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
