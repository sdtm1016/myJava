package net.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketServer {
	public static int port = 12345;

	public static void main(String[] args) {

		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			// 监听
			// Server端接收信息后,解除阻塞,会向下运行
			// 为了保证Server一直运行,就应设计一个死循环
			while (true) {
				Socket soc = serverSocket.accept();
				System.out.println("正在接收..");
				// print(soc);
				// 输入流
				InputStream is = soc.getInputStream();
				// 输出流
				OutputStream os = soc.getOutputStream();

				BufferedReader br = new BufferedReader(new InputStreamReader(is, "gbk"));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "gbk"));

				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println("Server readLine: " + line);
					line = "return " + line + "\r\n";
					bw.write(line);
					bw.flush();
					System.out.println("br.write: " + line);
				}
				br.close();
				bw.close();
				// soc.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void print(Socket soc) {
		SocketAddress saddr = soc.getRemoteSocketAddress();
		System.out.println(saddr + " connection sucess !");
		InetAddress iaddr = soc.getInetAddress();
		System.out.println("iaddr.getHostName(): " + iaddr.getHostName());
		// System.out.println("iaddr.getAddress(): " + new
		// String(iaddr.getAddress()));
		System.out.println("iaddr.getHostAddress(): " + iaddr.getHostAddress());
	}
}
