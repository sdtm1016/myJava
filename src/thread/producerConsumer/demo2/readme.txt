生产者消费者模型

熊Bear每次吃12斤蜜,蜜蜂每次产生1斤蜜
Box够20时候,熊可以吃,单位消费周期10s
蜜蜂有Bag可以保存10斤,产够5斤后可以放(0-5斤)到蜜罐Box中
多只蜜蜂产蜜,多只熊吃蜜,蜜罐容量20斤

根据Bag控制三种情况:
a1.	0<Bag<5 --> Bee可以产,Bag不能加
a2.	Bag>=5 --> Bee可以产,Bag可能加
a3.	Bag=20 --> Bee不可以产,Bag可能加

根据Box控制情况:
b1.	Box=0 --> wait/notify
b2. Box<Max  --> Bear不能消费,Bag可以加
b3. Box=Box.Max --> Bear消费,Bag不能添加,wait/notify

组合逻辑关系:
对于生产者较为复杂,Bee生产直接是受Bag状态控制的,而Bag又受Box状态控制:
基本逻辑关系如下:
while(true){
	if(a1+a2){
		Bag++	(生产)
		if(a2){
			b1+b2-->Box.put(Bag)
			b3-->notify(Bear)
		}
	if(a3){
		b1+b2-->Box.put(Bag)
		b3-->notify(Bear)+wait(Bee)
		//注:这里notify不用设,原因有二:
		1.以bag增加顺序,在此之前已经notify了Bear
		即运行顺序为:a2-->b3-->notify(Bear)
		2.程序到Bear后,Bear的wait条件b1+b2与这里b3没有交集
		即逻辑:在b3时Bear不会wait,自然不需要在a3-->b3时notify
	}
}
对于消费者,Bear只简单受Box状态控制
while(true){
	b3-->Box-=Bear.eat+notify(Bee)	(消费)
	b1+b2-->wait(Bear)
}

对于synchronized,首先在对象上选择公共部分即:Box
选择同步区域:含有Box及wait和notify的部分均需要同步
对于wait和notify:
抓住生产者停止点(wait)进行控制当前线程暂停等待,
然后在对应消费者中找到唤醒点notify,对应消费者的停止和唤醒同理
