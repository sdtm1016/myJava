package net.socket.qqDemo.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import net.socket.qqDemo.common.ClientTextMessage;
import net.socket.qqDemo.utils.SocketUtil;

/**
 * Controller层 发送消息
 */
public class SenderThread extends Thread {
	private ClientTextMessage message;
	private String text;
	public String username;
	private OutputStream os;

	public SenderThread(Socket sock, String username) {
		try {
			this.username = username;
			this.os = sock.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		synchronized (this) {
			char[] chars = text.toCharArray();
			StringBuffer buf = new StringBuffer(username);
			buf.append(":\r\n    ");
			for (int i = 0; i < chars.length; i++) {
				buf.append(chars[i]);
				if (chars[i] == '\r' || chars[i] == '\n') {
					buf.append("    ");
					if (i + 1 < chars.length && chars[i + 1] == '\n') {
						i++;
					}
				}
			}
			this.text = buf.toString();
			this.notify();
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (text == null) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			message = new ClientTextMessage(text.getBytes());
			SocketUtil.writeMessage(os, message);
			text = null;
		}
	}
}
