http://blog.csdn.net/a19881029/article/details/9465663
RMI:远程方法调用(Remote Method Invocation)。
能够让在某个Java虚拟机上的对象像调用本地对象一样
调用另一个java 虚拟机中的对象上的方法。
RMI远程调用步骤：
	1，客户对象调用客户端辅助对象上的方法
	2，客户端辅助对象打包调用信息（变量，方法名），
	通过网络发送给服务端辅助对象
	3，服务端辅助对象将客户端辅助对象发送来的信息解包，
	找出真正被调用的方法以及该方法所在对象
	4，调用真正服务对象上的真正方法，并将结果返回给服务端辅助对象
	5，服务端辅助对象将结果打包，发送给客户端辅助对象
	6，客户端辅助对象将返回值解包，返回给客户对象
	7，客户对象获得返回值
对于客户对象来说，步骤2-6是完全透明的

搭建一个RMI服务的过程分为以下7步;
1，创建远程方法接口Hello，该接口必须继承自Remote接口
Remote 接口是一个标识接口，用于标识所包含的方法
可以从非本地虚拟机上调用的接口，Remote接口本身不包含任何方法
由于远程方法调用的本质依然是网络通信，只不过隐藏了底层实现，
网络通信是经常会出现异常的，所以接口的所有方法都
必须抛出RemoteException以说明该方法是有风险的

2，创建远程方法接口实现类：HelloImpl
UnicastRemoteObject类的构造函数抛出了RemoteException，
故其继承类不能使用默认构造函数，继承类的构造函数必须也抛出RemoteException
由于方法参数与返回值最终都将在网络上传输，故必须是可序列化的

3，利用java自带rmic工具生成sutb存根类(jdk1.5.0_15/bin/rmic)
jdk1.2以后的RMI可以通过反射API可以直接将请求发送给真实类，
所以不需要skeleton类了
sutb存根为远程方法类在本地的代理，是在服务端代码的基础上生成的，
需要HelloImpl.class文件，由于HelloImpl继承了Hello接口，故Hello.class文件
也是不可少的
Test
- - server
- - - - Hello.class
- - - - HelloImpl.class
方式一：
rmic server.HelloImpl 
方式二：
rmic -classpath /home/name/Test server.HelloImpl
 运行成功后将会生成HelloImpl_Stub.class文件
 4，启动RMI注册服务(jdk1.5.0_15/bin/rmiregistry)
 方式一：后台启动rmiregistry服务
 jdk1.5.0_15/bin/rmiregistry 12312 & 
 ps -ef|grep rmiregistry 
 如果不带具体端口号，则默认为1099
 方式二：人工创建rmiregistry服务，需要在代码中添加：
 LocateRegistry.createRegistry(12312); 
 5，编写服务端代码HelloServer
 先创建注册表，然后才能在注册表中存储远程对象信息
 6，运行服务端（58.164）：
Test
- - server
- - - - Hello.class
- - - - HelloImpl.class
- - - - HelloServer.class
java server.HelloServer 
HelloServer启动成功
7，编写客户端代码HelloClient
8，运行客户端（58.163）：
Test
- - client
- - - - HelloClient.class
- - server
- - - - Hello.class
- - - - HelloImpl_Stub.class//服务端生成的存根文件
java client.HelloClient  
Hello,zx  
同服务器端，/home/name/Test一定要在系统CLASSPATH中
顺序
1.server注册:
Server[HelloServer]--(1.Naming.binc)-->rmiregistry[h{prot:12312}]
2.客户端
Client[HelloClient]--(2.Naming.lookup)-->rmiregistry[h{port:12312}]
3.rmirgistry
rmiregistry[h{port:12312}]-->Client[HelloImpl_Stub]
4.Client加载class
Client[HelloClient-->HelloImpl_Stub]
5.Client[Hello_Stub]-->Server[HelloImpl]
PS：
1，客户端所在服务和服务端所在的服务器网络一定要通
2，所有代码在jdk1.5.0_15，Linux服务器上调试通过
3，如果java命令运行提示找不到类文件，则为CLASSPATH配置问题
JAVA_HOME为jdk的根目录
PATH为java工具类路径(java，javac，rmic等)
CLASSPATH为java .class文件的存放路径，使用java命令运行.
class文件时即会在该参数配置的路径下寻找相应文件

java RMI的缺点：
1，从代码中也可以看到，代码依赖于ip与端口
2，RMI依赖于Java远程消息交换协议JRMP（Java Remote Messaging Protocol)
该协议为java定制，要求服务端与客户端都为java编写