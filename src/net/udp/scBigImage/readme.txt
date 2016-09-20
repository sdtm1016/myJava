大包发送
--------------------
	udp限制64kb,切割若干个小package
	每张图大小: totalLength = x;
	每个包大小: perPack = 50k;
	每张图对应的包个数: count = x/50 +1;
	udp如果丢包1个,这一组包(一张整图对应的pack)将无效,
		所以每个package应该尽可能大
		或者每张图的字节长度尽可能小
package拆分设计:
	为了区分每个包对应的图和图字节数组对应的offset,进行如下定义:
	区分图顺序使用: system.current.nanotime(速度快,微秒回重复)
	每个包头部: (组号)8byte+(组序号id)1byte+(组中包个数)1byte
接收组装包逻辑:
byte[] buf = new byte[64 << 10];
DatagramPacket pack = new DatagramPacket(buf, buf.length);
socket.receive(pack);
通过pack.getLength和pack.getData解析获取真正的数据,这里为了方便,将收到的包解析后封装为packProtocol
然后通过packProtocol的组id,包id组装数据
	这里先使用Map<gid,List<byte[]>>缓冲数据,当包数量够了之后,对包组装
	如果一段时间内(或已经收到gid+3的包)以后,自动丢弃该Map中所有数据


	存储选择:
		Map<gid,List<byte[]>>:gid用时间表示,List索引保证组中包的位置
		Map<gid,Map<index,byte[]>>:Map中index表示每个包序号

1s内没有收集齐,丢弃
set中最多只保存两组image
	