多线程下载
	地址:http://mirrors.tuna.tsinghua.edu.cn/apache/hadoop/common/hadoop-3.0.0-alpha1/hadoop-3.0.0-alpha1-src.tar.gz
	使用:RandomAccessFile,将文件分成n部分,开启n个链接,
	Thread(>=3)
seek://