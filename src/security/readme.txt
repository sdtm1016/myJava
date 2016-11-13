我们知道,编程中数据的传输,保存,为了考虑安全性的问题,需要将数据进行加密.我们拿数据库做例子.
	如果一个用户注册系统的数据库,没有对用户的信息进行保存,如,我去页面注册,输入"Vicky","123456".注册.
	web服务器未对数据进行加密而直接写入数据库,那么数据库中的用户信息,便是一个直接可用的数据!
	一旦服务器服务器被黑~那么用户的信息将毫无保留的展现在黑客面前...
为了解决这个弊端,现在大多数都会将信息进行MD5加密.
如"Vicky"与"123456"加密后,会生成16位或者32位字符串.而黑客即便获得这些数据也无法使用...

Java加密架构，java平台中用于访问和开发加密功能的框架。
MessageDigest 类
MessageDigest 类是一个引擎类，它是为了提供诸如 SHA1 或 MD5 等密码上安全的报文摘要功能而设计的。
密码上安全的报文摘要可接受任意大小的输入（一个字节数组），并产生固定大小的输出，该输出称为一个摘要或散列。摘要具有以下属性：
	无法通过计算找到两个散列成相同值的报文。
	摘要不反映任何与输入有关的内容。

使用报文摘要可以生成数据唯一且可靠的标识符。有时它们被称为数据的“数字指纹”。
创建 MessageDigest 对象
    计算摘要的第一步是创建报文摘要实例。
    象所有的引擎类一样，获取某类报文摘要算法的 MessageDigest 对象的途径是调用 MessageDigest 类中的 getInstance 静态 factory 方法：
        public static MessageDigest getInstance(String algorithm)
	注意：算法名不区分大小写。例如，以下所有调用都是相等的：
		MessageDigest.getInstance("SHA")
		MessageDigest.getInstance("sha")
		MessageDigest.getInstance("sHa")
	调用程序可选择指定提供者名称，以保证所要求的算法是由已命名提供者实现的：
		public static MessageDigest getInstance(String algorithm, String provider)
	调用 getInstance 将返回已初始化过的报文摘要对象。因此，它不需要进一步的初始化。

更新报文摘要对象
    计算数据的摘要的第二步是向已初始化的报文摘要对象提供数据。这将通过一次或多次调用以下某个 update（更新）方法来完成：
		public void update(byte input)
		public void update(byte[] input)
		public void update(byte[] input, int offset, int len)

计算摘要
    通过调用 update 方法提供数据后，程序就调用以下某个 digest（摘要）方法来计算摘要：
		public byte[] digest()
		public byte[] digest(byte[] input)
		public int digest(byte[] buf, int offset, int len)
	前两个方法返回计算出的摘要。后一个方法把计算出的摘要储存在所提供的 buf 缓冲区中，起点是 offset。len 是 buf 中分配给该摘要的字节数。该方法返回实际存储在 buf 中的字节数。
	对接受输入字节数组变量的 digest 方法的调用等价于用指定的输入调用：
	    public void update(byte[] input)
	，接着调用不带参数的 digest 方法.
	示例一:
	★ 编程思路：

	java.security包中的MessageDigest类提供了计算消息摘要的方法，首先生成对象，执行其update( )方法可

	以将原始数据传递给该对象，然后执行其digest( )方法即可得到消息摘要。具体步骤如下：


	（1）生成MessageDigest对象

	MessageDigest m=MessageDigest.getInstance("MD5");

	分析：和2.2.1小节的KeyGenerator类一样。MessageDigest类也是一个工厂类，其构造器是受保护的，不允许

	直接使用new MessageDigist( )来创建对象，而必须通过其静态方法getInstance( )生成MessageDigest对象。

	其中传入的参数指定计算消息摘要所使用的算法，常用的有"MD5"，"SHA"等。若对MD5算法的细节感兴趣可参考

	http://www.ietf.org/rfc/rfc1321.txt。

	（2）传入需要计算的字符串

	m.update(x.getBytes("UTF8" ));

	分析：x为需要计算的字符串，update传入的参数是字节类型或字节类型数组，对于字符串，需要先使用

	getBytes( )方法生成字符串数组。

	（3）计算消息摘要

	byte s[ ]=m.digest( );

	分析：执行MessageDigest对象的digest( )方法完成计算，计算的结果通过字节类型的数组返回。

	（4）处理计算结果

	必要的话可以使用如下代码将计算结果s转换为字符串。

	String result="";

	for (int i=0; i

	result+=Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);

	}
	★代码与分析：
	完整程序如下：
	import java.security.*;
	public class DigestPass{
	public static void main(String args[ ]) throws Exception{

	String x=args[0];

	MessageDigest m=MessageDigest.getInstance("MD5");

	m.update(x.getBytes("UTF8"));

	byte s[ ]=m.digest( );

	String result="";

	for (int i=0; i

	result+=Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);

	}

	System.out.println(result);

	}

	}

	★运行程序

	输入java DigestCalc abc来运行程序，其中命令行参数abc是原始数据，屏幕输出计算后的消息摘要：

	900150983cd24fb0d6963f7d28e17f72。



	示例二:


	    public String EncoderByMd5(String str) throws NoSuchAlgorithmException,
	UnsupportedEncodingException{
	        //确定计算方法
	        MessageDigest md5=MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	        return newstr;
	    }
	调用函数：String str="0123456789"

	 System.out.println（EncoderByMd5（str））；

	 输出：eB5eJF1ptWaXm4bijSPyxw==
