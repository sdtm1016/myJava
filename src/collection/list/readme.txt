List
------------------------------------------------------------
List/Set<--Collection
interface List/Set<E> extends Collection<E>
特征:
List有序(数组方式内存中连续存储,通过下标指定)可重复
Set无序(hash散列存储方式,查询搜索访问快)不重复
Map <Key,Value>对映射

List可以存储相同对象,原理:
	List初始化分3步
		1.在栈的main函数中定义变量List list;
		2.在jvm的堆内存中new一个ArrayList对象;
		3.将list指向到堆中ArrayList的位置
	List中添加对象步骤:
		1.在Jvm堆中new一个Student对象,并在栈中创建一个引用s(在java语言中可以理解为属性)
		2.add(s)时候,在ArrayList容器中添加一个引用
		3.多次add(s),ArrayList中有对Student做了多次引用
		See: ListDemo.java

Arraylist
-----------------------------------------------------------
Arraylist<--AbstractList<E><--AbstractCollection<E><--List<E>
        <--List<E>
        <--RandomAccess, Cloneable, java.io.Serializable
Arraylist是一个动态(可改变大小的)数组列表,使用了数组实现,它允许所有元素，包括 Null
	ArrayList内部封装一个Object数组:elementData,并记录size
	(这里是add对象的组成的list长度,它不会超过capacity)
	在ArrayList初始化时候,默认分配一个空数组:EMPTY_ELEMENTDATA,
	当向里面添加add第一个对象时候,会更改为默认Capacity为10的数组
	当然也可以new的时候在构造器中指定容量的参数
迭代器Itr:
	内部迭代器分析:Itr implements Iterator<E>:其中next方法实现:
	通过判断元素下标cursor并返回cursor+1,即数据下标方式
	List还提供一个listIterator()方法返回一个 ListIterator接口，和标准的Iterator接口相比，
	ListIterator多了一些add()之类的方法，允许添加，删除，设定元素，还能向前或向后遍历。
随机访问:
	元素通过下标get/set访问
频繁增删(add和remove,特别是中间add)问题:
	将导致移动数据,源码add(i,E):
	先检测索引下标的有效性,并通过ensureCapacityInternal(size+1)处理arrbuf的size增加的情况
	接下来将被插入位置后的所有对象向右移动1位,源码中调用系统数组复制:
	即System.arraycopy(elementData, index, elementData, index + 1,size - index)
	这会复制从index开始的elementData数组到[index+1,size-index]区间
	然后将插入对象element赋值给elementData[index],最后记录保存:size++
	解释:
	Arraylist基于数组实现的，而数组是一块连续的内存空间，
	如果在数组的任意位置插入元素,必然导致在该位置后的所有元素需要重新排列
	因此其效率较差,要尽可能将数据插入到尾部

效率:元素通过下标get/set访问,查询快:
	Size、IsEmpty、Get、Set等方法可以通过size属性/元素下标获取直接操作:即运行时间为常数O(1)
	其他的方法通过遍历方式操作即:运行时间为线性O(n)
	注意:ArrayList对于随机位置的add/remove，时间复杂度为 O(n),
	但是对于列表末尾的添加/删除操作,时间复杂度是 O(1). (最佳情况)
容量(Capacity)问题:
	源码分析:在对ArrayList增加(add操作)对象的时候,会调用到ensureCapacityInternal(size+1)
	它会根据情况生成一个minCapacity的值(10或size+1)然后调用ensureExplicitCapacity(minCapacity)
	而这个方法会增加修改结构的次数modCount,然后判断目前用到的容量minCapacity是否要超出容器的最大容量length
	如果minCapacity-length > 0,将进行增加容量:grow(minCapacity)
	其会根据elementData.length进行增加一半操作,然后调用工具类Arrays.copyOf(elementData, newCapacity)
	对elementData进行copy扩容
	解释:
	每个 ArrayList实例都有一个容量(Capacity),用于存储元素的数组的大小,这个容量可随着不断添加新元素而自动增加
	注意 默认情况下ArrayList的初始容量非常小,当需要插入大量元素时，需要进行扩容
	扩容过程中，会进行大量的数组复制操作，而数组复制时，最终将调用 System.arraycopy()方法
	最佳实践:
	1.在插入前可以调用 ensureCapacity方法来增加 ArrayList的容量以提高插入效率
	2.如果可以预估数据量的话,分配一个较大的初始值,这样可以减少调整大小的开销。
	3.当元素个数固定，用Array，因为Array效率是最高的
Demo.java代码练习包含: Arraylist的遍历,for循环简化,增强for循环,强制转换
	1.	Boolean add(Object o) 将指定元素添加到列表的末尾；
	2.	Boolean add(int index,Object element) 在列表中指定位置加入指定元素；
	3.	Boolean addAll(Collection c) 将指定集合添加到列表末尾；
	4.	Boolean addAll(int index,Collection c) 在列表中指定位置加入指定集合；
	5.	Boolean clear() 删除列表中所有元素；
	6.	Boolean clone() 返回该列表实例的一个拷贝；
	7.	Boolean contains(Object o) 判断列表中是否包含元素；
	8.	Boolean ensureCapacity(int m) 增加列表的容量，如果必须，该列表能够容纳 m 个元素；
	9.	Object get(int index) 返回列表中指定位置的元素；
	10.	Int indexOf(Object elem) 在列表中查找指定元素的下标；
	11.	Int size() 返回当前列表的元素个数。
源码解析See:Arraylist.txt
扩展阅读：
	在java.util.concurrent包中定义的CopyOnWriteArrayList提供了 线程安全的ArrayList
	但是当进行add和set等变化操作时它是通过为底层数组创建新的副本实现的，所以比较耗费资源
与数组Array对比
	数组类型:
		数组[]可以为基本类型并且必须一致,初始化需直接指定
		ArrayList为除基本数据类型外的任意对象,初始化可以默认Object
	容量:
		数组[]可以Array.Resize()更改大小
		ArrayList根据需要自动扩充
	数组下限设定:数组[]可以,ArrayList不能,永远是0
	数组维度:数组[]可以多维,ArrayList永远一维
	命名空间:数组[]是System,ArrayList是System.Collections
	占用内存:[]小,ArrayList为对象,较大
	使用实际:[]需要明确指定数据个数并且类型一致,ArrayList是元素个数不一致,各种类型
	效率:
		数组[]最高效,建议：首先使用数组，无法确定数组大小时才使用ArrayList
		ArrayList由于数组扩容,执行add/addRange/Insert内部数组的容量不够时
		会以当前容量的两倍来重新构建一个数组，将旧元素Copy到新数组中，然后丢弃旧数组
		这个临界点的扩容操作，应该来说是比较影响效率
	类型识别(JDK1.5后支持泛型,相关概念:擦除):
		ArrayList存入对象时，抛弃类型信息，所有对象屏蔽为Object，编译时不检查类型，但是运行时会报错。
	互相转换:
		ArrayList转换为数组:list.toArray(new String[0])
		数组转换为ArrayList:Arrays.asList(arr[])

LinkedList
----------------------------------------
LinkedList<--AbstractSequentialList<--AbstractList<E><--AbstractCollection<E><--List<E>
	<--List<E>
	<--Deque<E><--Queue<E><--Collection
	<--Cloneable:覆盖了函数clone()，能克隆
	<--java.io.Serializable:支持序列化，能通过序列化去传输
LinkedList是双向链表结构(,队列,堆栈)
继承AbstractSequentialList双向链表,它也可以被当作堆栈、队列或双端队列进行操作。
	LinkedList提供额外的 Get、Remove、Insert等方法在 LinkedList的首部或尾部操作数据
	也就是说:
	这些操作使得 LinkedList可被用作堆栈（Stack）、队列（Queue）或双向队列（Deque）。
	
数据结构解析:
	Node节点内部类:
	其内部类Node属性:prev和next指向上一个/下一个节点(在数据结构通常称为前后节点的指针)
	节点实例element保存业务数据,允许 Null元素
	LinkedList包含属性 Node<E> first;Node<E> last;int size = 0;
first与last的性质-->Queue:
	其中first的Node没有prev,last的Node没有next;
	first和last可通过对应的get方法获取first和last的节点;
	其是实现Deque接口的方法,Deque是Queue队列的子类,该接口比List提供了更多的方法,包括 offer(),peek(),poll()等.

无容量限制:
	LinkedList由于使用了链表的结构，因此不需要维护容量的大小,
	然而每次的元素增加都需要新建一个 Entry对象，并进行更多的赋值操作，
	在频繁的系统调用下，对性能会产生一定的影响，在不间断地生成新的对象还是占用了一定的资源。
	因为数组的连续性，因此总是在尾端增加元素时，只有在空间不足时才产生数组扩容和数组复制
非线程安全:如果多个线程同时访问一个 List,必须自己实现访问同步,一种解决方法
	List list = Collections.synchronizedList(new LinkedList(...))
随机访问:
	LinkedList要移动指针遍历比较
插入源码解析:
	add(i,E)会通过checkPositionIndex检查有效性,判断是否是尾部add
	不是则调用linkBefore(element, node(index))它是将两个节点作为参数(可以思考linkBefore的含义)
	linkBefore(e,succ)会先把要找到被插入节点的前一个节点:prev = succ.prev,然后对涉及到的三个节点分别修改或初始化:
		1.new出要插入的节点:newNode(pred, e, succ),这里已经初始化了newNode三个属性
		2.然后修改被插入节点succ的prev,指向newNode,即:succ.prev = newNode
		3.更改前一个节点prev的next指向:
			这里也会判断add的位置是否开头即:pred == null,如果是则将first指向node
			如果是不是将前一个节点pred的next指向node
	LinkedList不会因为插入数据导致性能下降。
	如果是尾部插入,add会调用linkLast,其过程为
		1.先取出lastnode保存到Node l,
		2.new出插入节点newNode(l, e, null)并将last指向它
		3.将原来是最后的节点l的next指向newNode,然后对size加1,并记录修改次数:modCount++
随机访问基于顺序遍历:
	获取元素可以使用iterator外还可以使用get(i)
	get(i)方法返回的是Node(i).item,Node(i)实现:利用for循环对Node.next依次遍历
	contains(xx)方法返回indexOf(o) != -1,其中indexOf方法
	是通过for循环从first遍历next比较实现,使用object的equal方法即==
	也就是说随机访问慢
效率:
	LinkedList对于随机位置的add/remove，时间复杂度为 O(n),
	但是对于列表 末尾/开头 的添加/删除操作,时间复杂度是 O(1).
	LinkedList增(删)速度比ArrayList稍快,但在get与set方面性能比ArrayList差很多
	当数据顺序无关的情况下，选择ArrayList还是LinkedList要从各动作的执行效率综合考虑。

时间复杂度		ArrayList/LinkedList
get(index i) 	O(1)	 O(n)
add(E e)		O(1)	 O(1) amortized
remove(index i)	O(n)	 O(n)
实践:LinkedList在 add和remove上更快,而在get上更慢(数据类型不同,JDK版本不同,优化不同，就可能有不同的结果)
	若只对单条数据插入或删除，ArrayList的速度反而优于LinkedList。
	但若是批量随机的插入删除数据，LinkedList的速度大大优于ArrayList.
	因为ArrayList每插入一条数据，要移动插入点及之后的所有数据。
	在分别有200000条“记录”的ArrayList和LinkedList的首位插入20000条数据，
	LinkedList耗时约是ArrayList的20分之1。
LinkedList更适用于
	没有大规模的随机读取
	大量的增加/删除操作
See:ListCompareDemo.java以及ArrayListAndLinkedList.java
其他源码解析:See LinkedList

Vector非常类似于 ArrayList(方法,属性/继承/接口)
Vector是一种老的动态数组，是线程同步的，效率很低
	在方法中加入了锁synchronized,是强同步类,因此开销就比 ArrayList要大.
同步的Iterator:
	由 Vector创建的 Iterator，虽然和 ArrayList创建的 Iterator是同一接口
	因为 Vector是同步的，当一个Iterator被创建而且正在被使用，另一个线程改变了 Vector的状态（例如，添加或删除了一些元素）
	这时调用 Iterator 的方法时将抛出ConcurrentModificationException，因此必须捕获该异常
Vector向量的功能：
	1.能存储任意对象
	2.不能存储基本类型的数据，如39，除非将这些数据包裹在包裹类中
	3.其容量可以按需求自动扩充
	4.若果不用扩充容量，增加元素方法的效率较高
比较:
	Vector与ArrayList用法基本一致,但是线程安全可同步化,效率低速度慢
	Vector每次请求其大小的双倍空间，而ArrayList每次对size增长50%.
	Vector确实有一点点优势，因为你可以指定增加值(方法应该是 setSize(int newSize))。
如果你的程序本身是线程安全的(thread-safe,没有在多个线程之间共享同一个集合/对象),那么使用ArrayList是更好的选择。
	See: VectorDemo.java
	
	注释:
	通过使用capacity和ensurecapacity操作以及capacityIncrement域可以优化存储操作，
	这个前面讲过，(Vector的Iterator和listIterator方法翻译的迭代器支持fail-fast机制，
	因此如果在使用迭代器的过程中有其他线程修改了map，
	那么将抛出ConcurrentModificationException，这就是所谓fail-fast策略。
	官方对此的说明是 java.util 包中的集合类都返回 fail-fast迭代器，
	这意味着它们假设线程在集合内容中进行迭代时，集合不会更改它的内容。
	如果 fail-fast迭代器检测到在迭代过程中进行了更改操作，
	那么它会抛出 ConcurrentModificationException，这是不可控异常。)


Stack
Stack继承自 Vector，实现了一个后进先出的堆栈
Stack 提供 5个额外的方法使得 Vector 得以被当作堆栈使用。
	除了基本的 Push和 Pop方法，
	还有 Peek方法得到栈顶的元素，
	Empty方法测试堆栈是否为空，
	Search方法检测一个元素在堆栈中的位置。
注意:Stack刚创建后是空栈。









