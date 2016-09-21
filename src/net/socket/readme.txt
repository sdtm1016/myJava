Java网络编程
	传统的网络编程是一项非常细节化的工作,程序员必须处理和网络有关的大量细节	
		如各种协议,甚至要理解网络相关硬件知识.
	Java则将底层的网络通信细节予以屏蔽,使得使用编程模型是一个文件模型,
		也就是说,可以向操作流一样来操作网络数据传输.
	另外,由于在网络连接中,通常都需要一个服务器同事为多个客户端服务,
		因此java的多线程机制也大派用场

java socket编程
一，网络编程中两个主要的问题
	一个是如何准确的定位网络上一台或多台主机，
	另一个就是找到主机后如何可靠高效的进行数据传输。
在TCP/IP协议中
	IP层主要负责网络主机的定位，数据传输的路由，由IP地址可以唯一地确定Internet上的一台主机。
	而TCP层则提供面向应用的可靠（tcp）的或非可靠（UDP）的数据传输机制，
	这是网络编程的主要对象，一般不需要关心IP层是如何处理数据的。

目前较为流行的网络编程模型是客户机/服务器（C/S）结构。
	即通信双方一方作为服务器等待客户提出请求并予以响应。
	客户则在需要服务时向服务器提 出申请。
	服务器一般作为守护进程始终运行，监听网络端口，一旦有客户请求，就会启动一个服务进程来响应该客户，
		同时自己继续监听服务端口，使后来的客户也能及时得到服务。

二，两类传输协议：TCP/UDP其他:(HTTP超文本协议/FTP)
TCP是Tranfer Control Protocol的简称，是一种面向连接的保证可靠传输的协议。
	通过TCP协议传输，得到的是一个顺序的无差错的数据流。
	发送方和接收方的成对的两个socket之间必须建 立连接，以便在TCP协议的基础上进行通信，
	当一个socket（通常都是server socket）等待建立连接时，另一个socket可以要求进行连接，
	一旦这两个socket连接起来，它们就可以进行双向数据传输，双方都可以进行发送 或接收操作。
TCP是面向连接的协议，在socket之间进行数据传输之前必然要建立连接，所以在TCP中需要连接时间。
	TCP传输数据大小限制，一旦连接建立起来，双方的socket就可以按统一的格式传输大的 数据。
	TCP是一个可靠的协议，它确保接收方完全正确地获取发送方所发送的全部数据。
TCP在网络通信上有极强的生命力，
	例如远程连接（Telnet）和文件传输（FTP）都需要不定长度的数据被可靠地传输。
	但是可靠的传输是要付出代价的，对数据内容正确性的检验必然占用计算机的处理时间和网络的带宽，
	因此TCP传输的效率不如UDP高。

UDP是User Datagram Protocol的简称:用户数据报协议,是一种无连接的协议，(QQ传输可以使用此协议:UDP,直播/视频聊天)
	每个数据报都是一个独立的信息，包括完整的源地址或目的地址，它在网络上以任何可能的路径传往目的地，
	因此能否到达目的地，到达目的地的时间以及内容的正确性都是不能被保证的。
UDP:每个数据报中都给出了完整的地址信息，因此无需要建立发送方和接收方的连接。
	UDP传输数据时是有大小限制的，每个被传输的数据报必须限定在64KB之内。
	UDP是一个不可靠的协议，发送方所发送的数据报并不一定以相同的次序到达接收方
UDP操作简单，而且仅需要较少的监护，因此通常用于局域网高可靠性的分散系统中client/server应用程序。
	例如视频会议系统，并不要求音频视频数据绝对的正确，只要保证连贯性就可以了，这种情况下显然使用UDP会更合理一些。


TCP和UDP的区别(接上,必须明白)
　　1、TCP是面向链接的，虽然说网络的不安全不稳定特性决定了多少次握手都不能保证连接的可靠性，但TCP的三次握手在最低限度上(实际上也很大程度上保证了)保证了连接的可靠性;
　　而UDP不是面向连接的，UDP传送数据前并不与对方建立连接，对接收到的数据也不发送确认信号，发送端不知道数据是否会正确接收，当然也不用重发，所以说UDP是无连接的、不可靠的一种数据传输协议。
　　2、也正由于1所说的特点，使得UDP的开销更小数据传输速率更高，因为不必进行收发数据的确认，所以UDP的实时性更好。
　　知道了TCP和UDP的区别，就不难理解为何采用TCP传输协议的MSN比采用UDP的QQ传输文件慢了，但并不能说QQ的通信是不安全的，
　　因为程序员可以手动对UDP的数据收发进行验证，比如发送方对每个数据包进行编号然后由接收方进行验证啊什么的，
　　即使是这样，UDP因为在底层协议的封装上没有采用类似TCP的“三次握手”而实现了TCP所无法达到的传输效率。




三，基于Socket的java网络编程
1，什么是Socket
	网络上的两个程序通过一个双向的通讯连接实现数据的交换，这个双向链路的一端称为一个Socket。
	Socket通常用来实现客户方和服务方的连接。
	Socket是TCP/IP协议的一个十分流行的编程界面，一个Socket由一个IP地址和一个端口号唯一确定。

	但是，Socket所支持的协议种类也不光TCP/IP一种，因此两者之间是没有必然联系的。
	在Java环境下，Socket编程主要是指基于TCP/IP协议的网络编程。
2，Socket通讯的过程
	1.Server端Listen(监听)某个端口是否有连接请求，(服务器端套接字并不定位具体的客户端套接字)
	2.Client端向Server端发出Connect(请求)，
	3.Server端向Client端发回Accept(接受)消息。
		当服务器端套接字监听到或者说接收到客户端套接字的连接请求时，
		就响应客户端套接字的请求，建立一个新的线程，
		把服务器端套接字的描述发给客户端，一旦客户端确认了此描述，双方就正式建立连接。
	4.Server端和Client端都可以通过Send，Write等方法与对方通信。
	
对于一个功能齐全的Socket，都要包含以下基本结构，其工作过程包含以下四个基本的步骤：
	（1） 创建Socket；
	（2） 打开连接到Socket的输入/出流；
	（3） 按照一定的协议对Socket进行读/写操作；
	（4） 关闭Socket.
	（在实际应用中，并未使用到显示的close，虽然很多文章都推荐如此，
	不过在我的程序中，可能因为程序本身比较简单，要求不高，所以并未造成什么影响。）

3，创建Socket
创建Socket
java在包java.net中提供了两个类Socket和ServerSocket(侦听产生Socket)
	分别用来表示双向连接的客户端和服务端。这是两个封装得非常好的类，使用很方便。

其构造方法如下：
	Socket(String host, int prot);
	Socket(String host, int prot, boolean stream);
	Socket(InetAddress address, int port);
	Socket(InetAddress address, int port, boolean stream);
	Socket(SocketImpl impl)
	Socket(String host, int port, InetAddress localAddr, int localPort)
	Socket(InetAddress address, int port, InetAddress localAddr, int localPort)

	ServerSocket(int port);
	ServerSocket(int port, int backlog);
	ServerSocket(int port, int backlog, InetAddress bindAddr)
其中
	address、host和port分别是双向连接中另一方的IP地址、主机名和端 口号，
	stream指明socket是流socket还是数据报socket，localPort表示本地主机的端口号，
	localAddr和 bindAddr是本地机器的地址（ServerSocket的主机地址），
	impl是socket的父类，既可以用来创建serverSocket又可 以用来创建Socket。
	count则表示服务端所能支持的最大连接数。例如：学习视频网 http://www.xxspw.com

　　Socket client = new Socket("127.0.0.1", 80);
　　ServerSocket server = new ServerSocket(80);
注意，在选择端口时，必须小心。
	每一个端口提供一种特定的服务，只有给出正确的端口，才 能获得相应的服务。
	0~1023的端口号为系统所保留，例如
		http服务的端口号为80,telnet服务的端口号为21,ftp服务的端口号为23, 
	所以我们在选择端口号时，最好选择一个大于1023的数以防止发生冲突。
	在创建socket时如果发生错误，将产生IOException，在程序中必须对之作出处理。
	所以在创建Socket或ServerSocket是必须捕获或抛出例外。

Socket底层通过SocketInputStream/SocketOutputStream对IO流进行封装

See:
5，支持多客户的client/server程序
前面的Client/Server程序只能实现Server和一个客户的对话。
在实际应用 中，往往是在服务器上运行一个永久的程序，它可以接收来自其他多个客户端的请求，提供相应的服务。为了实现在服务器方给多个客户提供服务的功能，需要对上 面的程序进行改造，利用多线程实现多客户机制。服务器总是在指定的端口上监听是否有客户请求，一旦监听到客户请求，服务器就会启动一个专门的服务线程来响 应该客户的请求，而服务器本身在启动完线程之后马上又进入监听状态，等待下一个客户的到来。

其他Code参考:
http://blog.csdn.net/baple/article/details/12552467








