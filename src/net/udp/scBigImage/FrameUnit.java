package net.udp.scBigImage;

import java.net.DatagramPacket;
import base.data.util.ByteArrayUtil;

/**
 * 组成一帧画面(图片)的每个单元
 */
public class FrameUnit {
	// 组id,时间
	private long gid;
	// 组中包数量
	private int count;
	// 包序号
	private int index;
	// 原始数据
	private byte[] rawData;

	public FrameUnit(DatagramPacket pack) {
		parsepack(pack);
	}

	private void parsepack(DatagramPacket pack) {
		byte[] packData = pack.getData();
		if (packData[8] == packData[9]) {
			packData = new byte[pack.getLength()];
			System.arraycopy(pack.getData(), 0, packData, 0, pack.getLength());
		}
		this.gid = ByteArrayUtil.byteArray2Long(packData);
		this.setIndex(packData[8]);
		this.count = packData[9];
		rawData = new byte[packData.length - 10];
		System.arraycopy(packData, 10, rawData, 0, packData.length - 10);// buf从第11个位置复制到rawData
	}

	long getGid() {
		return gid;
	}

	void setGid(long gid) {
		this.gid = gid;
	}

	int getCount() {
		return count;
	}

	void setCount(int count) {
		this.count = count;
	}

	int getIndex() {
		return index;
	}

	void setIndex(int index) {
		this.index = index;
	}

	byte[] getRawData() {
		return rawData;
	}

	void setRawData(byte[] rawData) {
		this.rawData = rawData;
	}

}
