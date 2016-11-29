(三)循环链表以及循环链表应用
单向循环链表
单向循环链表是单链表的另一种形式，其结构特点是链表中最后一个结点的指针不再是结束标记，而是指向整个链表的第一个结点，从而使单链表形成一个环。和单链表相比，循环单链表的长处是从链尾到链头比较方便。当要处理的数据元素序列具有环型结构特点时，适合于采用循环单链表。

与单链表相同，循环单链表也有带头结点结构和不带头结点结构两种，带头结点的循环单链表实现插入和删除操作时，算法实现较为方便。
带头结点的循环单链表结构如下：
http://img.blog.csdn.net/20131004225934640?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZmFuZ2Z1bGx5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center
带头结点的循环单链表的操作实现方法和带头结点的单链表的操作实现方法类同，差别仅在于：

（1）在构造函数中，要加一条head.next = head 语句，把初始时的带头结点的循环单链表设计成图2-11 （a）所示的状态。

（2）在index(i)成员函数中，把循环结束判断条件current != null改为current != head。(见上篇博客)



双向循环链表

双向链表是每个结点除后继指针外还有一个前驱指针。和单链表类同，双向链表也有带头结点结构和不带头结点结构两种，带头结点的双向链表更为常用；另外，双向链表也可以有循环和非循环两种结构，循环结构的双向链表更为常用。
在双向链表中，每个结点包括三个域，分别是element域、next域和prior域，其中element域为数据元素域，next域为指向后继结点的对象引用，prior域为指向前驱结点的对象引用。下图为双向链表结点的图示结构。
http://img.blog.csdn.net/20131004231115296?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZmFuZ2Z1bGx5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center
如下图是带头结点的循环双向链表的图示结构。循环双向链表的next和prior各自构成自己的循环单链表。
http://img.blog.csdn.net/20131004231148125?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZmFuZ2Z1bGx5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center

在双向链表中，有如下关系：设对象引用p表示双向链表中的第i个结点，则p.next表示第i+1个结点，p.next.prior仍表示第i个结点，即p.next.prior== p；同样地，p.prior表示第i-1个结点，p.prior.next仍表示第i个结点，即p.prior.next ==p。下图是双向链表上述关系的图示。
http://img.blog.csdn.net/20131004231241343?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZmFuZ2Z1bGx5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center
循环双向链表的插入过程如下图所示。图中的指针p表示要插入结点的位置，s表示要插入的结点，①、②、③、④表示实现插入过程的步骤。
http://img.blog.csdn.net/20131004231442796?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZmFuZ2Z1bGx5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center
循环双向链表的删除过程如下图所示。图中的指针p表示要插入结点的位置，①、②表示实现删除过程的步骤。
http://img.blog.csdn.net/20131004231542859?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZmFuZ2Z1bGx5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center