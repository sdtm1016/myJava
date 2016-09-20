package net.socket.qqDemo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Set;

import base.data.util.ByteArrayUtil;
import net.socket.qqDemo.common.Message;

public class SocketUtil {
	// 获得主机名
	public static String getHostName() {
		try {
			return readString(Runtime.getRuntime().exec("hostname").getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获得socket对应的主机ip地址和socket端口
	public static String getAddr(Socket socket) {
		String ip = socket.getInetAddress().getHostName();
		return ip + ":" + socket.getPort();
	}

	// 从输入流中读取一个byte,处理成消息类型:0好友列表,1文本内容
	public static int readMessageType(InputStream is) {
		try {
			return is.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;// 异常
	}

	// 读取消息长度
	public static int readMessageLen(InputStream is) {
		byte[] buf = new byte[4];
		try {
			is.read(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 字节数组转换为int
		return ByteArrayUtil.byteArray2Int(buf);
	}

	// 读取指定长度的消息内容
	public static byte[] readMessage(InputStream is, int len) {
		// 这里排除Mb,Gb,Tb级别的情况,直接保存在一个字节数组中
		byte[] buf = new byte[len];
		try {
			is.read(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf;
	}

	// 反序列化好友列表
	public static Set<String> readFriends(byte[] bytes) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
			Set<String> friends = (Set<String>) ois.readObject();
			ois.close();
			return friends;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 序列化好友列表
	public static byte[] writeFriends(Set<String> friends) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(friends);
			oos.close();
			baos.close();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 反序列化文本内容
	public static String readText(byte[] bytes) {
		// return readText(bytes, "utf-8");
		System.out.println(new String(bytes));
		return new String(bytes);
	}

	// 反序列化文本内容
	public static String readText(byte[] bytes, String charset) {
		try {
			return new String(bytes, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 发送消息
	public static void writeMessage(OutputStream os, Message message) {
		try {
			// os.write(message.getPack());
			os.write(message.getType());
			os.write(ByteArrayUtil.int2ByteArray(message.getLength()));
			os.write(message.getContent());
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 读取流中数据到
	public static byte[] readByte(InputStream is) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		int len = 0;
		try {
			while ((len = is.read(buff)) != -1) {
				baos.write(buff, 0, len);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static String readString(InputStream is) {
		return new String(readByte(is));
	}

	public static String readString(InputStream is, String charset) {
		try {
			return new String(readByte(is), charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}