package net.socket.thread.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSender extends Thread {
	Socket socket;
	PrintWriter os;
	BufferedReader is;
	BufferedReader sin;

	public ClientSender(Socket socket) {
		try {
			os = new PrintWriter(socket.getOutputStream());
			sin = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		try {
			String readline = sin.readLine();
			while (!readline.equals("bye")) {
				os.println(readline);//输出到socket
				os.flush();
				System.out.println("input :" + readline);
				readline = sin.readLine();
			}
			os.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
