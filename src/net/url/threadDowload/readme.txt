多线程下载网络文件
--------------------
View:
	ui:
	1.url路径
	2.本地路径
	3.下载按钮
	4.下载进度
	5.暂停/继续按钮
	6.下载结束提示

controller:
	DowLoaderManager:
	1.处理下载准备工作
	// 1.提取文件大小// 1.2 设置ui进度条最大值
	// 2.创建本地文件
	// 3.准备dowload集合(这里将下载信息面向对象:dowloadInfo)
	2.开始下载//启动下载线程处理:
	// url.openConnection()获取流
	// setRequestProperty("Range","xxx")组装Range
	// RandomAccessFile定位本地文件
	// IO编程传输
	// 关闭流,结束
		
Model:
	dowloadInfo
	包含:
	private String url;
	private String local;
	private int startPos;
	private int endPos;