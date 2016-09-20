package net.udp.scBigImage;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.imageio.ImageIO;

import base.data.util.ByteArrayUtil;

public class ScreenBrocastServer {

	public static int port = 8888;
	static DatagramSocket sock;
	static int lenPerPack = 50 * 1024;// 定义包定义长度,50*1024 = 50kb

	public static void main(String[] args) {
		try {
			// 创建屏幕的抓图区域
			Robot robot = new Robot();
			// Rectangle ract = new Rectangle(0, 0, 1366, 768);
			Rectangle ract = new Rectangle(0, 0, 800, 600);

			sock = new DatagramSocket();
			InetAddress addr = InetAddress.getByName("192.168.0.3");
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				byte[] rowdata = captureScreen(robot, ract);
				splitPack(rowdata, addr, port);
				// List<DatagramPacket> packs = splitPack(rowdata, addr, port);

			}
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param robot
	 *            awt包的机器人进行抓图
	 * @param ract
	 *            指定区域
	 * @return 返回BufferedImage对象
	 */
	public static byte[] captureScreen(Robot robot, Rectangle ract) {
		BufferedImage image = robot.createScreenCapture(ract);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "jpg", baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
	}

	/**
	 * 切割原始报文,生成n个pack对象
	 */
	public static void splitPack(byte[] rawData, InetAddress addr, int port) {
		// 一张图对应总长
		int allLen = rawData.length;

		// pack的个数
		int count = allLen % lenPerPack == 0 ? allLen / lenPerPack : allLen / lenPerPack + 1;
		// List<DatagramPacket> packs = new ArrayList<DatagramPacket>();
		DatagramPacket pack = null;// pack包
		byte[] newPack = null;// pack数组
		int len = lenPerPack;// pack默认length

		// groupId组号:时间long转换为byte数组
		byte[] gid = ByteArrayUtil.long2ByteArray(System.nanoTime());

		for (int i = 0; i < count; i++) {// 循环切分rawData
			if (i == (count - 1)) {
				len = allLen % lenPerPack;
				System.out.println("最后包长度: " + len);
			}
			newPack = new byte[len + 10];
			System.arraycopy(gid, 0, newPack, 0, 8);
			newPack[8] = (byte) (i + 1);// packId,从1开始
			newPack[9] = (byte) count;// packSum
			System.arraycopy(rawData, lenPerPack * i, newPack, 10, len);// data

			pack = new DatagramPacket(newPack, newPack.length, addr, port);
			try {
				sock.send(pack);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// packs.add(pack);
			// return packs;
		}
	}
}
