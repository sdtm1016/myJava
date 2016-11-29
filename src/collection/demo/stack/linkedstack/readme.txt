(五)链式堆栈的实现与应用
链式堆栈

链式存储结构的堆栈称作链式堆栈。
与单链表相同，链式堆栈也是由一个个结点组成的，每个结点由两个域组成，一个是存放数据元素的数据元素域element，另一个是存放指向下一个结点的对象引用（即指针）域next。
堆栈有两端，插入数据元素和删除数据元素的一端为栈顶，另一端为栈底。链式堆栈都设计成把靠近堆栈头head的一端定义为栈顶。
依次向链式堆栈入栈数据元素a0, a1, a2, ..., an-1后，链式堆栈的示意图如图所示。
http://img.blog.csdn.net/20131005174801703?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZmFuZ2Z1bGx5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center