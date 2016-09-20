package net.udp.scBigImage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户端接收线程
 */
public class ClientReceiveThread extends Thread {
	private Map<Long, Map<Integer, FrameUnit>> frames = new HashMap<Long, Map<Integer, FrameUnit>>();

	// 或者
	// private Map<Long, MyFream> myFrames = new HashMap<Long, MyFream>();
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
			byte[] buf = new byte[64 * 1024];
			DatagramPacket pack = new DatagramPacket(buf, buf.length);
			try {
				// 接收数据
				socket.receive(pack);
				FrameUnit unit = new FrameUnit(pack);
				
				Map<Integer, FrameUnit> unitMap = frames.get(unit.getGid());
				if (unitMap == null) {
					unitMap = new HashMap<Integer, FrameUnit>();
					unitMap.put(unit.getIndex(), unit);
					frames.put(unit.getGid(), unitMap);
				} else {
					unitMap.put(unit.getIndex(), unit);
				}
				
				if (unitMap.size() == unit.getCount()) {
					// 包齐全后合成
					byte[] imageData = mergeImage(unitMap);
					ui.refreshImage(imageData);
					frames.remove(unit.getGid());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 合成image
	 * 
	 * @param unitMap
	 *            image对应的一组帧单元
	 * @return 返回image的字节数组
	 */
	private byte[] mergeImage(Map<Integer, FrameUnit> unitMap) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			for (int i = 0; i < unitMap.size(); i++) {
				FrameUnit u = unitMap.get(i + 1);// 索引从1开始
				baos.write(u.getRawData());
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
