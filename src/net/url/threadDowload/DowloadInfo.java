package net.url.threadDowload;

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
	
}
