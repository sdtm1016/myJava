package io.charStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BufRead2WriterDemo {
	public static void main(String[] args) throws IOException {
		// 对一个文件做读写操作
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("E:/Workspaces/FileInput/utf-8.txt")));

		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("E:/Workspaces/FileOutput/bufWriter.txt")));

		PrintWriter out = new PrintWriter("E:/Workspaces/FileOutput/printWriter.txt");
		// PrintWriter pw1 = new PrintWriter(outputStream, boolean
		// autlFlush);//自动刷新
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);

			bw.write(line);
			// 单独写出换行操作 bw.newLine();
			// 换行操作 bw.flush();

			out.println(line);
			out.flush();
		}
		bw.close();
		out.close();
		br.close();

	}
}
