package net.socket.thread.demo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerResponse extends Thread {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;

	public ServerResponse(Socket socket) {
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "gbk"));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "gbk"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String line;
		try {
			while (true) {
				line = br.readLine();// 读取socket输入阻塞
				System.out.println("Client:" + line);
				bw.write(line + "\r\n");// 输出到socket
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
