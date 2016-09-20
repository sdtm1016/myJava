在实际的项目开发中会有很多的对象，如何高效、方便地管理对象，成为影响程序性能与可维护性的重要环节。
Java 提供了集合框架来解决此类问题，线性表、链表、哈希表等是常用的数据结构
在进行 Java 开发时，JDK 已经为我们提供了一系列相应的类来实现基本的数据结构，
所有类都在 java.util 这个包里，Collection接口与Map的总体框架图
Collection  
├List  
│├LinkedList  
│├ArrayList  
│└Vector  
│　└Stack  
└Set  
Map  
├Hashtable  
├HashMap  
└WeakHashMap  

Collection是最基本的集合接口,一个 Collection代表一组 Object，即 Collection的元素（Elements）。
Collection仅持有对象引用(指向对象的指针),
	而不是将对象信息copy一份至数列某位置。
	一旦将对象置入容器内，便损失了该对象的型别信息。
JDK提供的类都是继承自 Collection的两个接口是 List和 Set,而Map自成体系;
所有实现 Collection 接口的类都必须提供两个标准的构造函数，
	无参数的构造函数用于创建一个空的 Collection，
	有一个 Collection参数的构造函数用于创建一个新的 Collection，这个新的 Collection与传入的 Collection有相同的元素，
后一个构造函数允许用户复制一个 Collection。

集合类:面向对象形式,使用集合类对对象进行存储
集合类和数组区别:
	集合长度可变,不能存放基本数据类型,能存不同类型对象
	Class/type[]数组的长度固定,可存基本数据类型

Collection与array[]数组,String的区别
	Class/type[]数组 :int length//方法
	String: int length()//方法
	Collection接口: int size();//方法
Collection 接口提供的主要方法：
	1.	boolean add(Object o) 添加对象到集合；
	2.	boolean remove(Object o) 删除指定的对象；
	3.	int size() 返回当前集合中元素的数量；
	4.	boolean contains(Object o) 查找集合中是否有指定的对象；
	5.	boolean isEmpty() 判断集合是否为空；//实际开发中做判断时候,应先判断null后判断isEmpty()
	6.	Iterator iterator() 返回一个迭代器；
	7.	boolean containsAll(Collection c) 查找集合中是否有集合 C 中的元素；
	8.	boolean addAll(Collection c) 将集合 C 中所有的元素添加给该集合；
	9.	void clear() 删除集合中所有元素；
	10.	void removeAll(Collection c) 从集合中删除 C 集合中也有的元素；
	11.	void retainAll(Collection c) 从集合中删除集合 C 中不包含的元素。

迭代器:Iterator
--------------------------------------
interface Collection<E> extends Iterable<E> 
Iterable接口定义可迭代,它只有唯一方法Iterator<T> iterator()获取跌迭代器
	iterator能够通过当前元素的方法hasNext()和next()迭代出下一个元素
	循环依次迭代,这个过程叫迭代,或者遍历
	集合内部每个元素间存在互相引用,即该元素存在一个地址指向下一个元素
	迭代器是一个指针,初始化时,指向第一个元素前面,hasNext()判断指针后是否有元素,
	然后next()获取该元素并将指针移动到该元素上,依次循环,最后it指向最后一个元素结束

Set
-------------------------------------------
Set子接口:无序，不允许重复
效率:
	Set检索元素效率低下，
	删除和插入效率高，插入和删除不会引起元素位置改变。<对应类有 HashSet,TreeSet>






List
----------------------------------------
List 是有序可重复的 Collection，使用此接口能够精确的控制每个元素插入的位置
用户能够使用索引（元素在 List 中的位置，类似于数组下标）来访问 List 中的元素，这类似于 Java 的数组
效率:
	List和数组类似，可以动态增长，查找元素效率高，
	插入删除元素效率低，因为会引起其他元素位置改变。<相应类有 ArrayList,LinkedList，Vector>

List还提供一个 listIterator() 方法，返回一个 ListIterator 接口
和标准的 Iterator接口相比，ListIterator多了一些 add()之类的方法，允许添加、删除、设定元素、向前或向后遍历等功能
for循环遍历List效率会非常低,建议使用Iterator迭代器的形式
	Iterator ite = list.iterator();
	while(ite.hasnext()){
		Object obj = ite.next();
	}
List接口提供的主要方法：
	1.	void add(int index,Object element) 在指定位置上添加一个对象；
	2.	boolean addAll(int index,Collection c) 将集合 C 的元素添加到指定的位置；
	3.	Object get(int index) 返回 List 中指定位置的元素；
	4.	int indexOf(Object o) 返回第一个出现元素 O 的位置；
	5.	Object removeint(int index) 删除指定位置的元素；
	6.	Object set(int index,Object element) 用元素 element 取代位置 index 上的元素，返回被取代的元素。
实现 List 接口的常用类有 LinkedList，ArrayList，Vector 和 Stack 等
List集合性能比较:
	ArrayList是首选，在多用于查询使用时,ArrayList的效率更高;
	但在频繁进行删除，插入操作的时候应该用LinkedList，
	比如在进行堆栈和队列的操作时，就应该用LinkedList执行，此时的执行效率比JAVA自带的stack要高

Map
----------------------------------------
Map没有继承 Collection 接口。Map 提供 Key 到 Value 的映射，
一个 Map 中不能包含相同的 Key，每个 Key 只能映射一个 Value。
Map 接口提供 3 种集合的视图，Map 的内容可以被当作一组 Key 集合，一组 Value 集合，或者一组 Key-Value 映射。
Map 提供的主要方法：
	1.	boolean equals(Object o) 比较对象；
	2.	boolean remove(Object o) 删除一个对象；
	3.	put(Object key,Object value) 添加 key 和 value。
Map集合性能比较: 
	HashMap是首选，但是在整个Map类会需要更多的内存空间，以为有键值对的存在.HashMap用到了哈希函数，
	所以其key必须是唯一 的，TreeMap是用红黑树进行实现的;Map还可用containKey()检查是否含量有某个key/value键值对

RandomAccess
----------------------------------------
RandomAccess接口是一个标志接口，本身并没有提供任何方法，
任务凡是通过调用 RandomAccess接口的对象都可以认为是支持快速随机访问的对象。
此接口的主要目的是标识那些可支持快速随机访问的 List 实现。
任何一个基于数组的 List 实现都实现了 RaodomAccess 接口，而基于链表的实现则都没有。
	因为只有数组能够进行快速的随机访问，而对链表的随机访问需要进行链表的遍历。
	因此，此接口的好处是，可以在应用程序中知道正在处理的 List 对象是否可以进行快速随机访问，
	从而针对不同的 List 进行不同的操作，以提高程序的性能。


Collections
--------------------------------------------
Collections是针对集合类的一个帮助类。提供了一系列静态方法实现对各种集合的搜索、排序、线程完全化等操作。
相当于对Array进行类似操作的类——Arrays。
如，Collections.max(Collection coll); 取coll中最大的元素。
Collections.sort(List list); 对list中元素排序


不同实现类之间的区别:
HashMap,ArrayList与HashTable,Vector的区别联系
	HashMap,ArrayList是异步执行的这样有助于提高工作效率，但并不是线程安全的.并且HashMap允许键值对的值为null;
	HashTable和Vector是同步执行的，但是线程安全,这样的效率不如HashMap和ArrayList
6.Collection与Collections的区别
	Collection是集合的接口类，而Collections是一个帮助类，提供了一些帮助函数，如搜索，反转等等


Genericity