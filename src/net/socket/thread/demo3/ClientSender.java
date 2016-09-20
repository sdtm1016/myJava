package net.socket.thread.demo3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSender extends Thread {
	Socket socket;
	Scanner in;
	BufferedWriter bw;

	public ClientSender(Socket socket) {
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "gbk"));
			in = new Scanner(System.in);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		try {
			String line = in.next();
			while (!line.equals("bye")) {
				bw.write(line + "\r\n");
				bw.flush();
				System.out.println("input :" + line);
				line = in.next();
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
