package net.udp.screenBrocast;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;

public class ScreenBrocastServer {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			DatagramSocket sock = new DatagramSocket();

			// 创建屏幕的抓图区域
			// Rectangle ract = new Rectangle(0, 0, 1366, 768);
			// Rectangle ract = new Rectangle(0, 0, 800, 600);//太大
			Rectangle ract = new Rectangle(0, 0, 600, 400);// 由于udp数据大小限制只能截取600*400大小图片
			Robot robot = new Robot();
			while (true) {
				// Thread.sleep(1000);
				// 通过Robot对象传参ract进行抓图,返回BufferedImage对象
				BufferedImage image = robot.createScreenCapture(ract);
				System.out.println(image);

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image, "jpg", baos);
				byte[] rawData = baos.toByteArray();
				System.out.println("rawData: " + rawData.length / 1024);
				// 截屏生成的照片比较大,可以使用java提供的压缩输出流ZipOutputStream
				// byte[] gzipData = gzipCompress(rawData);
				// System.out.println("gzipData: " + gzipData.length / 1024);

				DatagramPacket pack = new DatagramPacket(rawData, rawData.length);
				// DatagramPacket pack = new DatagramPacket(gzipData,
				// gzipData.length);
				pack.setAddress(InetAddress.getByName("192.168.0.3"));// 通过ip获取地址
				pack.setPort(8888);
				sock.send(pack);
				baos.close();
			}
			// 通过图像工具类,对RenderedImage实例对象生成一个指定文件格式的输出流
			// ImageIO.write(image, "jpg", new
			// FileOutputStream("file/image.jpg"));

			// 联系udp的datagramSocket,如果持续发送image,那么就可以形成视频
			// 但BufferedImage不能序列化,
			// Raster raster = image.getData();
			// JFream中展示图片的控件
			// Toolkit.getDefaultToolkit().

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 压缩过程
	public static byte[] gzipCompress(byte[] data) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream gzos = new GZIPOutputStream(baos);
			gzos.write(data);
			gzos.flush();
			gzos.close();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
