package net.socket.thread.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientRequest extends Thread {
	Socket socket;
	PrintWriter os;
	BufferedReader is;
	BufferedReader sin;

	public ClientRequest(Socket socket) {
		try {
			os = new PrintWriter(socket.getOutputStream());
			is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
				System.out.println("Server return:" + is.readLine());
				readline = sin.readLine();//系统输入阻塞
			}
			os.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
