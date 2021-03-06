TCP/IP是一个协议栈(不是一个协议，而是一个协议族的统称)
里面包括了IP协议，IMCP协议，TCP协议，以及http、ftp、pop3协议等等。
和操作系统的运行机制一样，必须要具体实现，同时还要提供对外的操作接口。
电脑有了这些，就好像学会了外语一样，就可以和其他的计算机终端做自由的交流了。

tcp/ip与socket:
	socket则是对TCP/IP协议的封装和应用(程序员层面上)。但与tcp/ip没有必然联系,
	socket是对tcp/ip的抽象,从而形成基本的函数接口(如:create,listen,connect,accept,send,read,write等)
	socket不属于ip/tcp的7层协议范畴,是tcp/ip提供程序员做网络开发的编程接口

TCP/IP协议分层
提到协议分层，我们很容易联想到ISO-OSI的七层协议经典架构，
但是TCP/IP协议族的结构则稍有不同。网络由下往上分为
物理层、数据链路层、网络层、传输层、会话层、表示层和应用层。
TCP/IP协议族按照层次由上到下，层层包装。(这里由内向外的顺序,或包装的先后顺序)

1.应用层:为应用程序提供网络服务,解决如何包装数据
	http:超文本传送协议(Hypertext Transfer Protocol )，
		是Web联网的基础，也是手机联网常用的协议之一，HTTP协议是建立在TCP协议之上的一种应用。
		HTTP连接最显著的特点是客户端发送的每次请求都需要服务器回送响应，
		在请求结束后，会主动释放连接。从建立连接到关闭连接的过程称为“一次连接”。
	telnet:终端仿真
	ftp,nfs,smtp,tftp,DNS:域名-->互联网地址)
	也可以自己定义应用层协议
	
2.表示层:数据表示,数据格式以及加密
	https,FTP允许二进制/ASCII格式传输

3.会话层:互联主机通信
	SQL(sctructure query language)
	RPC:服务器端提供一个借口和真正的实现,并提供一套客户端api的jar包给客户端作为远程代理,
	该api封装了底层的通信,客户端导入该jar包,与该代理类对象交互,
	该代理底层通过sorket套接字编程与服务器对应的真正实现的方法传输(客户端提供的参数,方法传输),
	服务端通过Serversorket侦听,接收客户端的请求通过真正的实现处理该请求并返回
		1.调用客户端句柄(java的代理对象)；执行传送参数
		2.调用本地系统内核发送网络消息(假定tcp/udp协议的存在)
		3.消息传送到远程主机
		4.服务器句柄得到消息并取得参数
		5.执行远程过程
		6.执行的过程将结果返回服务器句柄
		7.服务器句柄返回结果，调用远程系统内核
		8.消息传回本地主机
		9.客户句柄由内核接收消息
		10.客户接收句柄返回的数据
	

4.传输层:端到端连接,解决数据如何在网络中传输,如纠错功能等
	通过协议端口(protocol port)与应用层的应用程序进行信息交互的
	应用层各种用户进程通过相应的端口与传输层实体进行信息交互
		端口16bit范围可以从0-65535,其中0-1023端口为熟知端口(Well_Know Port)
		如:FTP:21,TELNE:23,SMTP:25,DNS:53,TFTP:69,SNMP:161
		其余成为一般端口(动态)链接端口(Registered/Dynamic)
		在数据阐述过程中,应用层中的各种不同的服务器进行不断的检测分配给他们的端口
		以便发现是否有某个应用进程要与它通信
	套接字的作用就是建立连接,Socket=IP+TCP/UDP+端口,
		其中ip地址表示主机,TCP/UDP协议用于指明传输套型端口标明使用的服务
	TCP和UDP协议:TCP(可靠流服务,面向连接,包含建立连接,数据传输(按序),连接释放)
		udp(不可靠,应用:星际,qq文件传送),SPX
	tcp协议数据格式:
		源端口srcPort16bit+宿端口destPort16bit
		+序列号seqNum32bit
		+数据偏移off4bit+保留(为0)6bit+URG,ACK,PSH,RST,SYN,FIN+窗口windowing16bit
		+校验和checksum16bit+紧急指针UrgentPointer 16bit
		+可选项Option32bit
		+数据Data32bit
    认识TCP标志位,tcp标志位有6种标示:
	    SYN(synchronous建立联机)
	    ACK(acknowledgement 确认)
	    PSH(push传送)
	    FIN(finish结束)
	    RST(reset重置)
	    URG(urgent紧急)
	
	TCP协议工作机制(三次握手),双方确认身份的过程
	第一次握手：客户端发送syn包(syn=j)到服务器，并进入SYN_SEND状态，等待服务器确认;
	第二次握手：服务器收到syn包，必须确认客户的SYN(ack=j+1)，
		同时自己也发送一个SYN包(syn=k)，即SYN+ACK包，此时服务器进入SYN_RECV状态;
	第三次握手：客户端收到服务器的SYN+ACK包，
		向服务器发送确认包ACK(ack=k+1)，此包发送完毕，
		客户端和服务器进入ESTABLISHED状态，完成三次握手。
	握手过程中传送的包里不包含数据，三次握手完毕后，客户端与服务器才正式开始传送数据。
	理想状态下，TCP连接一旦建立，在通信双方中的任何一方主动关闭连接之前，TCP连接都将被一直保持下去。
	断开连接时服务器和客户端均可以主动发起断开TCP连接的请求，
	断开过程需要经过“四次握手”(就是服务器和客户端交互，最终确定断开)
	
	四次挥手过程：
	第一次挥手：当传输的数据到达尾部时，host1向host2发送FIN=1标志位；
		可理解成，host1向host2说，我这边的数据传送完成了，我准备断开了连接；
	第二次挥手：因TCP的连接是全双工的双向连接，关闭也是要从两边关闭；
		当host2收到host1发来的FIN=1的标志位后，
		host2不会立刻向host1发送FIND=1的请求关闭信息，而是先向host1发送一个ACK=1的应答信息，
		表示：你请求关闭的请求我已经收到，但我可能还有数据没有完成传送，你再等下，等我数据传输完成了我就告诉你；
	第三次挥手：host2数据传输完成，向host1发送FIN=1，
		host1收到请求关闭连接的请求后，host1就明白host2的数据已传输完成，现在可以断开连接了，
	第四次挥手：host1收到FIND=1后，host1还是怕由于网络不稳定的原因，怕host2不知道他要断开连接，
		于是向host2发送ACK=1确认信息进行确认，把自己设置成TIME_WAIT状态并启动定时器，
		如果host2没有收到ACK，host2端TCP的定时器到达后，会要求host1重新发送ACK，
		当host2收到ACK后，host2就断开连接；
		当host1等待2MLS（2倍报文最大生存时间）后，没有收到host2的重传请求后，他就知道host2已收到了ACK，
		所以host1此时才关闭自己的连接。这一点我觉得设计得非常巧妙！
			
	
	UDP:是一种无连接的协议,在无连接情况下,两个实体之间的通信不需先建立好一个连接
	因此其下层有关资源不需要事先进行预订保留,这些资源将在数据传输时动态地进行分配
	无连接的另一个特征:就是它不需要通信的两个实体同时是活跃的(即激活状态)
	无连接的有点是灵活方便和比较迅速,但无连接服务不能防止报文的丢失,重复和失序
	无连接特别适合传送少量零星的报文

5.网络层:确定地址和最佳路径,负责逻辑地址,可以将大的数据包拆成小的数据包,利于网路传输
	IP协议:它负责对数据加上IP地址和其他的数据以确定传输的目标。
	ip数据报格式:ipv4-->ipv6
	{4bit版本+4bit首部长度+8bit服务类型(TOS)+16bit(字节)总长度
	+16bit标识+3bit标识+13bit片偏移
	+8bit生成时间(TTL)+8bit协议+16bit首部检验和
	+32bit源ip地址+32bit目的地址ip}(以上20byte)+选项(如果有)+数据
	ICMP(差错控制),
	ARP(互联网地址-->物理地址)
	RARP(物理地址-->互联网地址)
	
6.叫数据链路层:介质访问,单个链路如何传输数据
	这个层次为待传送的数据加入一个以太网协议头，并进行CRC编码，为最后的数据传输做准备。
	SLIP,PPP

7.物理层,即硬件，负责网络的传输，二进制传输
	定义包括网线的制式，网卡的定义等等
	所以有些书并不把这个层次放在tcp/ip协议族里面，因为它几乎和tcp/ip协议的编写者没有任何的关系。
	
发送协议的主机从上自下将数据按照协议封装，而接收数据的主机则按照协议从得到的数据包解开，最后拿到需要的数据。
	这种结构非常有栈的味道，所以某些文章也把tcp/ip协议族称为tcp/ip协议栈。
如下:
以太帧头(4.数据链路层)+IP头(3.网路层) +TCP头(2.传输层)+FTP头(1.应用层)+数据(应用数据)
以太帧头+目的地址+源地址+包类型+包数据+CRC

http://blog.chinaunix.net/uid-26833883-id-3627644.html
http://blog.csdn.net/goodboy1881/article/details/665061



















http://blog.csdn.net/baple/article/details/10202623


