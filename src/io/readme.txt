IO(input/output)流
Java对数据操作通过流的方式,io流处理设备间数据传输
按操作分为字节/字符流;按流向分为输入/输出流
抽象基类:
	字符流(二进制)InputStream,OutputStream
	字节流Reader,Writer

关于二进制与文件:
 	严格的说文件系统中的每个文件都是二进制文件。
 	各种文本字符是由一个或几个字节组成的，其中每个字节的数据不能是任意的。
 	如果一个文件中的每个字节或每相邻的几个字节中的数据都可以表示成某种字符，我们就可以称这个文件为文本文件。
 	可见文本文件只是二进制文件的一种特例。
 为了与文本文件相区别，人们又把文本文件以外的文件称之为二进制文件。
在概念上我们可以简单的认为：
 	如果一个文件专用于存储文本字符而没有 包含字符之外的其他数据，就称之为文本文件，除此之外的文件就是二进制文件。
----------------------------------------------------------------
Reader和Writer是所有字符流类的抽象基类，用于简化对字符串的输入输出编程，即用于读写文本数据。
Reader与Writer类及其子类（FileReader和FileWriter类等）主要用于读取文本格式的内容，
而InputStream和OutputStream类及它们的子类主要读取二进制格式的内容。

字符流write操作步骤:
	创建流对象,建立数据存储文件:FileWriter fw = new FileWriter("Text.txt");
	调用流对象的写方法,将数据写入:fw.write("text");
	关闭流资源,并将流中的数据清空到文件中:fw.close();
字符流read操作:
	建立一个流文件,将已存在的一个文件加载进流:FileReader fr = new FileReader("");
	创建一个临时存放数据的数组:char[] ch = new char[1024];
	调用流对象的读取方法将流中数据读入到数组:fr.read(ch);
注:定义文件路径时,可以用"/"或者"\\"
在创建一个文件时,如果目录下有同名文件将被覆盖
在读取文件必须保证文件存在,否则报错


字符流的缓冲区
	缓冲区的出现提高了对数据的读写效率
	对应类:BufferedWriter/BufferedReader,作用:避免对物理磁盘的频繁访问
	缓冲区结合流才可以使用,在流的基础功能上进行增强

FileReader继承关系:
继承关系:FileReader-->InputStreamReader-->abstract Reader implements Readable, Closeable
Closeable接口规定关闭流资源(可关闭),
在FileReader构造函数FileReader(String fileName)调用父类InputStreamReader构造器:super(new FileInputStream(fileName));
InputStreamReader构造器InputStreamReader(InputStream in)中再次调用父类Reader构造器:super(in);
这个属于装饰模式的设计,即FileReader通过构造器调用super构造器,然后对父类进行装饰
	Reader(Object lock)流读写时定义一个同步锁,可在实现类中实现
	子类InputStreamReader(InputStream in)指定super(in)后构造一个字符流读取器读取字节
	最后FileReader是对父类构造器进一步装饰,根据字符串创建输入流:new FileInputStream(fileName)
See:FileReaderDemo.java/FileWriterDemo.java/CopyFileDemo.java

BufferedWriter
----------------------------------------------------------------
继承关系:BufferedWriter-->Writer implements Appendable, Closeable, Flushable
	BufferedWriter继承复合Writer并在构造器中初始化,也就是对Writer做装饰
	BufferedWriter含有数组缓冲区char cb[],可以在类构造器中指定大小初始化,默认值8192足够使用
注释解析:newLine()方法由本地系统行分隔符定义,不同系统行分隔符不同,对文本识别后换行
	通常Writer直接输入数据到字符流或系统底层字节(数组缓冲区),除非立即输出
	建议通过Writer.write方法包装一个BufferedWriter,如 FileWriters/OutputStreamWriters
	关于FileWriter本身没有新增任何功能,没有缓冲区功能,继承OutputStreamWriter-->Writer
	而OutputStreamWriter的write均调用se.write,在sun.nio.cs.StreamEncoder包下(未开源)
	See:BufferedWriterDemo.myWriter

BufferedWriter源码分析:
	write(int c)方法先通过synchronized(lock)保证同步并检测流是否开启后,
	判断缓冲区是否写满(nextChar >= nChars)并清空:flushBuffer()
		这里的流程:Writer方法的write先将数据输出到系统内存字符缓冲区char[] cb中
	然后写入一个字符并增加索引:cb[nextChar++] = (char) c;
	其他两中write方法:write(String s, int off, int len)和write(char cbuf[], int off, int len)
	分别是写入一个字符串或一个字符数组
	目的是提高效率,但其效率不一定快于FileWriter
	其close方法先flushBuffer()然后out.flush
See:BufferedWriterDemo.java
注:行分割分在java中通过System.getProperty("line.separator")获取,不同平台行分隔符不一样,Windows7下是\r\n
See: SystemPropertyTest.java

BufferedReader/FileReader
---------------------------------------------------
BufferedReader-->Reader implements Readable, Closeable 
FileReader-->InputStreamReader-->Reader
	FileReader类似于FileWriter没有做任何方法扩展,
	其继承的InputStreamReader中writer方法调用sd.read()在sun.nio.cs.StreamDecoder包下
	BufferedReader数组缓冲区char cb[],read方法与BufferedWriter方法类似
	注释:默认cb[].size=8k,通常每次Reader的读请求 会引起 字符流或系统底层字节缓冲区的的读取请求
	通常通过如:FileReaders/InputStreamReaders等对Reader进行包装read,这将缓冲磁盘文件数据到缓冲区
	如果没有缓冲区每次read/readLine操作将导致从磁盘文件读取字节然后转换为字符,这会非常低效
BufferedReader的read()方法解析:
	synchronized (lock)同步ensureOpen()检查,
	循环判断如果含有\n跳过继续循环,最终返回一个缓冲区的一个字符并控制索引+1即:return cb[nextChar++]
	其中如果字符位置nextChar超过缓冲区size,则填满输入的缓冲区fill(),然后二次判断nextChar >= nChars则返回-1表示填充满
	read方法是读取缓冲区的字节,避免直接在磁盘文件进行一个个字符读取,即频繁访问磁盘
子类:LineNumberReader,行号阅读器
	set/get当前行的编号,默认从0开始每逢行终止符递增,并不改变缓冲区的索引,仅仅改变 getLineNumber()的返回值
See:BufferedReaderDemo.java

字节流FilterInputStream/FilterOutputStream
=========================================================

字节流缓冲区
	提高字节流的读写效率
BufferedOutputStream-->FilterOutputStream-->OutputStream implements Closeable, Flushable
	装饰模式,close方法
BufferedInputStream-->FilterInputStream-->InputStream implements Closeable
	close释放与之关联的系统资源,多次关闭没有影响,从外部向里面关闭


