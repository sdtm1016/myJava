package net.socket.thread.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerResponse extends Thread {
	Socket socket;
	PrintWriter os;
	BufferedReader is;

	public ServerResponse(Socket socket) {
		this.socket = socket;
		try {
			is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			os = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String line;
		try {
			while (true) {
				line = is.readLine();// 读取socket输入阻塞
				System.out.println("Client:" + line);
				os.println(line);// 输出到socket
				os.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
