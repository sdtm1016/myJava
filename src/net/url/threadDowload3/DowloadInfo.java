package net.url.threadDowload3;

/**
 * 下载信息对象
 * 
 * @author Noah
 *
 */
public class DowloadInfo {
	private String url;
	private String local;
	private int startPos;
	private int endPos;
	// 线程索引编号
	private int index;
	// 已经下载的数据量
	private int amount;

	public DowloadInfo() {
		super();
	}

	public DowloadInfo(String url, String local, int startPos, int endPos) {
		super();
		this.url = url;
		this.local = local;
		this.startPos = startPos;
		this.endPos = endPos;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
