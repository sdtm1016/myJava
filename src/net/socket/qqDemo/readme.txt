模拟qq(群聊版)

MVC(Model-View-Controller)模型,视图,控制
1.View
GUI为视图使用Java GUI
	1.显示聊天记录模块:chatArea
	2.输入模块:inputArea
	3.发送按钮:sentButton
	4.朋友列表:frendsList
	frendsList使用JTable,属于视图
2.Controller
	消息服务器使用Java Socket网络编程
	MessageServer控制层
	启动App后,打开视图,然后启动MessageServer
	当有其他client连接进来时候,触发refreshFriendsList刷新frendsList
	视图中frendsList自动显示连接的人
	另一方面:连接到一个人,就要保持与之对应的聊天窗口中显示聊天信息,如果有多个人的话就是并发
	也就是在client连接进来后,以多线程方式启动一个
3.Model
	frendsList的TableModel属于模型层

	
功能划分:	
MessageServer服务器,
	1.接收Socket
	2.接收client的消息
	3.将消息转发给所有人/指定人
client客户端:	
	1.建立连接
	2.接收server的联系人列表,跟新好友列表
	3.写入数据到server


伪代码:
Server:
	ss =new ServerSocket();
	ss.accept()
	updateContext()//更新自己的列表
	pushList()//推送好友列表到所有人
	reciveMessage();
	pushMessage()
	

client:
	s = new Socket();
	update()//好友列表
	reciveMessage()
	appendChatArea()

多线程:
	创建灵活响应的桌面程序

聊天区需要对服务器发送的消息合并,这里要清楚
	1.是聊天消息还是列表信息
	2.这个消息到什么地方结束,
所以制定一个消息协议很关键,设计如下:
	第1个字节定义为消息的类型:0表示好友列表信息,1表示聊天内容
	第2-4个字节定义一个消息字节数组的size
	后面为消息具体内容

	















