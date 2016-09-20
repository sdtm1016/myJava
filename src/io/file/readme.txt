RandomAccessFile
RandomAccessFile-->DataOutput, DataInput, Closeable 
RandomAccessFile的对象包含一个记录指针，用于标识当前流的读写位置，这个位置可以向前移动，也可以向后移动。
RandomAccessFile包含两个方法来操作文件记录指针。
	long getFilePoint():记录文件指针的当前位置。
	void seek(long pos):将文件记录指针定位到pos位置。
	skipBytes(int n):使指针跳过n个字节-->seek(newpos);
RandomAccessFile包含InputStream的三个read方法，也包含OutputStream的三个write方法。
同时RandomAccessFile还包含一系列的readXxx和writeXxx方法完成输入输出。
RandomAccessFile的构造方法如下
RandomAccessFile(File file, String mode)
RandomAccessFile(String name, String mode)
mode的值有四个
	"r":以只读文方式打开指定文件。如果你写的话会有IOException。
	"rw":以读写方式打开指定文件，不存在就创建新文件。
	"rws":s只元数据是否支持读写
	"rwd":也不介绍。


