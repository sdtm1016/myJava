一些概念： 
通信信道（communication channel）：将字节序列从一个主机传输到另一个主机的一种手段，可能是有线电缆，如以太网（Ethernet），也可能是无线的，如WiFi，或是其他方式的连接。 

信息（information）是指由程序创建和解释的字节序列。在计算机网络环境中，这些字节序列称为分组报文（packet）。 

协议（protocol）相当于相互通信的程序达成的一种约定，它规定了分组报文的交换方式和它们包含的意义。一组协议规定了分组报文的结构（例如报文中的哪一部分表明了目的地址）以及怎样对报文中所包含的信息进行解析。 

TCP和UDP属于传输层，IP属于网络层，TCP，UDP和IP的具体实现通常驻留在主机的操作系统中。应用程序通过套接字API对UDP协议和TCP协议所提供的服务进行访问。 

IP协议提供了一种数据报服务：每组分组报文都由网络独立处理和分发，就像信件或包裹通过邮政系统发送一样。IP报文必须包含一个保存其目的地址的字段，就像你所投递的每份包裹都写明了收件人地址一样。 

TCP协议和UDP协议使用的地址叫做端口号，都是用来区分同一主机中的不同应用程序的。 

客户端（client）是通信的发起者，而服务器（server）程序则被动等待客户端发起通信，并对其作出响应。 

一个程序是作为客户端还是服务器，决定了它在与其对等端（peer）建立通信时使用的套接字API（客户端的对等端是服务器，反之亦然）。客服端必须首先知道服务器端的地址和端口号，反之则不需要。这个打电话类似。只要通信连接建立成功，服务器和客户端之间就没有区别了。 


Socket(套接字）是一种抽象层，应用程序通过它来发送和接受数据，就像应用程序打开一个文件句柄，将数据读写到稳定的存储器上一样。一个TCP/IP套接字由一个互联网地址，一个端对端协议（TCP或UDP协议）以及一个端口号唯一确定。

1.InetAddress类和SocketAddress用于识别网络主机 
TCP协议客户端和服务器端的套接字为Socket和ServerSocket 
UDP协议的客户端和服务器端的套接字为DatagramSocket 

2. 
类 NetworkInterface表示一个由名称和分配给此接口的 IP 地址列表组成的网络接口，其getNetworkInterfaces()返回此机器上的所有接口。getInetAddresses()是返回一个 Enumeration 并将所有 InetAddress 或 InetAddress 的子集绑定到此网络接口的便捷方法。（注意：一个网络接口可能包含IPv4或IPv6地址） 

3.类 InetAddress的getHostAddress()返回 IP 地址字符串（以文本表现形式）。 getAllByName(String host)在给定主机名的情况下，根据系统上配置的名称服务返回其 IP 地址所组成的数组。getHostName()获取此 IP 地址的主机名。getHostAddress() 返回 IP 地址字符串（以文本表现形式）。 

4.TCP套接字 
服务器端ServerSocket实例监听TCP链接请求，并为每个请求创建新的Socket实例。也就是说，服务器端要同时处理ServerSocket实例和Sockete实例，而客户端只需要使用Socket实例。 