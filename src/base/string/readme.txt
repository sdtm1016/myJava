String str1 = "abc";
String str2 = new String("abc");
jvm内存分为堆栈,堆,方法区,
方法区保存类的地方,执行类时候进入方法区并控制静态代码块的执行.创建对象在堆区(new对象和数组arr);
new String("abc")是在堆中new一个对象,而"abc"在 java内存堆中的字符串池(简称串池),
也就是 new String("abc") 会在堆中开辟空间并在空间中引用串池的数据,然后这个堆的对象被str引用.
而String str = "abc"是str直接引用串池的"abc"
String的等值问题
	1.==判断是否为同一对象,判断对象的内存地址
	2.equals判断两个对象的内容是否相等

常用编码表
ASCII	美国标准信息交换码(一个字节7bits)
ISO8859-1	拉丁码表,欧洲码表(一个字节8bits),中文进行getBytes后,反编译将会是?
GB2312	中文编码表
GBK	中文编码表升级,中文字符,2个字节表示一个中文
Unicode	国际标准码(融合多种文字),所有文字都用两个字节表示
UTF-8	最多3个字节表示一个字符(2个字节字母,3个字节中文)
Charset java-->编译,str.getBytes("gbk")
str有中文时候,必须用含有中文的编码表进行编码,同时解码使用相同的编码表

编码解码:
byte[] bytes= "中国".getBytes("iso-8859-1");//对字符串编码
new String(bytes,Charset);//解码
编码和解码使用的编码表要一致

java使用unicode编码,满足多平台性
由此,如果输入unicode码,jvm将会自动转换为本地定义的编码格式对应的字符See:CharsetDemo
jdk提供的bin/native2ascii工具实现中文转码
	1.创建一个文本文件(gbk编码,推荐使用记事本工具)
		例:file/gb2312.txt内容:你好!a中b国c
	2.通过cmd进入file/文件目录
	3.执行命令:native2ascii -encoding gb2312 gb2312.txt ascii.txt
	4.打开生成的ascii文件,可以看到See: file/ascii.txt
	使用jvm系统标准输出该字符串,将会看到显示的是gb2312.txt中的内容

在jre/lib/charsets.jar包含所有字符集,nio.cs.ext包下打开class文件中可以看到各种字符对应的各种编码
也就是说标准输出(阅读器对内存对数据读取到内存中的)字符和二进制文件中保存的字符,按照规定的编码格式形成对应映射
例如对于eclipse:
	如果使用gbk写代码保存为文件,然后切换编码为utf-8阅读,将会发现中文都是乱码
这将类似于如下方式:
	byte[] bytes= "我的代码文件".getBytes("gbk");//保存格式
	System.out.println(new String(bytes, "utf-8"));//读取方式
	

StringBuffer线程安全,性能慢,为了提升性能jdk1.5出现StringBuilder
StringBuilder线程不安全,在单线程访问性能有3倍快于StringBuffer



