堆栈的基本概念

堆栈（也简称作栈）是一种特殊的线性表，堆栈的数据元素以及数据元素间的逻辑关系和线性表完全相同，其差别是线性表允许在任意位置进行插入和删除操作，而堆栈只允许在固定一端进行插入和删除操作。
堆栈中允许进行插入和删除操作的一端称为栈顶，另一端称为栈底。堆栈的插入和删除操作通常称为进栈或入栈，堆栈的删除操作通常称为出栈或退栈。

从输入和输出数据元素的位置关系看，堆栈的功能和一种火车调度装置的功能类同。

http://img.blog.csdn.net/20131005163145359?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZmFuZ2Z1bGx5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center
堆栈抽象数据类型
数据集合

  堆栈的数据集合可以表示为a0,a1,…,an-1，每个数据元素的数据类型可以是任意的类类型。
操作集合

（1）入栈push(obj)：把数据元素obj插入堆栈。

（2）出栈pop()：出栈,删除的数据元素由函数返回。

（3）取栈顶数据元素getTop()：取堆栈当前栈顶的数据元素并由函数返回。

 （4）非空否notEmpty()：若堆栈非空则函数返回true，否则函数返回false。
顺序栈
顺序存储结构的堆栈称作顺序堆栈。
顺序堆栈的存储结构示意图如图所示

http://img.blog.csdn.net/20131005163418468?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZmFuZ2Z1bGx5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center