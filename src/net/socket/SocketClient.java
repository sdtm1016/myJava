package net.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketClient {
	private static String serverHost = "localhost";
	private static int port = 12345;

	public static void main(String[] args) {

		Socket soc;
		try {
			soc = new Socket(serverHost, port);
			OutputStream os = soc.getOutputStream();
			InputStream is = soc.getInputStream();

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "gbk"));
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "gbk"));
			// 发送数据,在服务端接收使用readLine,需要标记换行符
			bw.write("hello\r\n world\r\n");
			bw.flush();
			System.out.println("Client readLine: " + br.readLine());

			br.close();
			bw.close();
			soc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
