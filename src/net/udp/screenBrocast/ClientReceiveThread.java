package net.udp.screenBrocast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.zip.GZIPInputStream;

//
public class ClientReceiveThread extends Thread {

	private ClientUI ui;
	DatagramSocket socket;

	public ClientReceiveThread(ClientUI ui) {
		try {
			this.ui = ui;
			socket = new DatagramSocket(8888);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			byte[] buf = new byte[1024 * 60];
			DatagramPacket pack = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(pack);
			} catch (IOException e) {
				e.printStackTrace();
			}
			int len = pack.getLength();
			// 解压数据无法实现
			// byte[] ungizpData = unGzip(buf, 0, len);

			// 更新ui
			// ui.refreshImage(ungizpData);
			byte[] data = new byte[pack.getLength()];
			System.arraycopy(buf, 0, data, 0, pack.getLength());
			System.out.println(data.length);
			ui.refreshImage(data);
		}
	}

	/**
	 * 使用gzip进行解压处理
	 */
	public static byte[] unGzip(byte[] srcData, int offset, int length) {
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(srcData, offset, length);
			GZIPInputStream gzis = new GZIPInputStream(bais);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = gzis.read(buf)) != -1) {
				baos.write(buf, 0, len);
			}
			gzis.close();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
