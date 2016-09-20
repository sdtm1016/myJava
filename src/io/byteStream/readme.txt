FileInputStream和FileOutputStream类
分别用来创建磁盘文件的输入流和输出流对象，通过它们的构造函数来指定文件路径和文件名。
创建FileInputStream实例对象时，指定的文件应当是存在和可读的。
创建FileOutputStream实例对象时，如果指定的文件已经存在，这个文件中的原来内容将被覆盖清除。
对同一个磁盘文件创建FileInputStream对象的两种方式：
	(1)FileInputStream inOne = new FileInputStream("hello.test");  
	(2)FileInputStream inTwo = new FileInputStream(new File("hello.test"));
创建FileOutputStream实例对象时，可以指定还不存在的文件名，但不能指定一个已被其他程序打开了的文件。

字节数组输出流
ByteArrayOutputStream-->OutputStream implements Closeable, Flushable 
------------------------------------
	1.不是缓冲区流,在内存中
	2.但含有一个字节数组buf能对数据进行自动写入,当流关闭后仍能通过toByteArray/toString被调用
	3.没有对任何流包装,构造器可以指定buf的size
	See:ByteArrayOutputStreamDemo.java

字节数组输入流
ByteArrayInputStream--> InputStream implements Closeable
	与ByteArrayOutputStream类似

 CharArrayReader/CharArrayWrite操作字符 
 StringReader/StringWriter 操作字符串


java IO体系中，java.io.ObjectOutputStream和java.io.ObjectInputStream
这两个类可以方便的实现对象的序列化(Serialize)和反序列化(Deserialize)
对象中的transient和static类型成员变量不会被读取和写入

对于serialVersionUID:表示一个类的版本,加入此属性后
	如果序列化一个Student类对象,然后对Student的类文件增删属性,
	然后再反序列化,不会因为删类文件导致反序列化时候属性的丢失,如果是增加属性,获取的值为0
对于构造器,反序列化后会根据根据继承顺序加载父类对应构造器
对于序列化对象A中复合有其他对象B,在序列化时候,此B也必须可序列化,否则运行抛异常
	但如果A类复合B,在序列化的A实例中没有B,这时候可以通过
	See:ObjectSerdeGraphDemo
关于深度复制See:ObjectSerdeGraphCopy

DataInputStream/DataOutputStram
数据输入输出流
http://blog.csdn.net/baple/article/details/3849466
包装类DataOutputStream、DataInputStream为我们提供了多种对文件的写入和读取方法，
如writeBoolean(),writeUTF()，writeChar，writeByte()，writeDouble()等和对应的read方法，
这些方法极大的方便了我们的写入和读取操作，下面结合一个程序来探讨一下这些方法的使用。
注意1：
	一般情况下在读入时尽量按照写入时的格式进行读取，
	否则有可能会出现显示乱码或程序出现异常。
	如首先写入文件用的是writeUTF()，在读取的时候如果不是用readUTF()就会出现乱码，
	如果readUTF()读取的内容不是UTF-8格式的，程序就会抛出异常。
注意2：
	如程序中注释所说，对于出现汉字字符的情况不能用writeBytes()，
	这会在写入文件时丢弃汉字字符的第一个字节从而在读取时出现错误。
注意3：
	所有的读取方法都是共享一个位置指示器的，即在前面的read方法执行后，
	后面再执行其他read方法都是从上一个read方法读取到的位置开始向后读取的。
	如开始执行了1次readByte()后面的readChar是从第2个字节开始读的。














