Map(key-value)键值对
================================================================
Map与Collection集合框架并列存在
	Map存储使用put,Collection使用add
	Map集合没有直接取出元素的方法,是先转成Set集合,在通过迭代获取元素
	Map集合中键要保证唯一性
	Map每个元素叫Entry<K,V>(条目),Entry是Map<K,V>接口内部接口,实例对象是一个k-v对
	Map所有的key位于Set容器中,也就是Map中所有key不能相同
	Set set = map.keySet();map.get(key)
	Map所有Value也位于Collection容器中,没有要求
使用场景:当存储很多大对象,对大对象提取出一个特征值作为key,value为该对象
这样所有key构成一个KeySet,存储空间小,且利用Set的特性,能够很容易获取key,然后又根据key快速找到Value
Map通用:
由于作为 Key的对象将通过计算其散列函数来确定与之对应的 Value的位置,
	因此任何作为 key的对象都必须实现 HashCode和 Equals方法。HashCode和 Equals方法继承自根类 Object
		如果你用自定义的类当作 Key的话，要相当小心，按照散列函数的定义:(注释或Set包中的readme.txt)
		如果两个对象相同，即 obj1.equals(obj2)=true，则它们的 HashCode必须相同
		但如果两个对象不同，则它们的 HashCode不一定不同，
	如果两个不同对象的HashCode相同，这种现象称为冲突:
		冲突会导致操作哈希表的时间开销增大，所以尽量定义好的HashCode()方法，能加快哈希表的操作。
	如果相同的对象有不同的 HashCode，对哈希表的操作会出现意想不到的结果（期待的 Get方法返回 Null），
		要避免这种问题，最好同时复写 Equals方法和 HashCode方法，而不要只写其中一个。
注:散列HashSet机制
	数据在内存中分布在多个空间(桶概念)
	hash将数据的特定属性进行hash得到值后取模(比如0-9个空间,取模后的值为n则该数据在第n个空间)
	访问可以通过该值迅速访问到对应的空间,然后通过数据比对就找到对应的元素
	Set使用会先判断hashcode是否相同,不同则存放,相同则再判断equals


HashMap
--------------------------------------------------------
HashMap是线程非同步的,且允许 Null，即 Null Value和 Null Key
HashMap所有的Key组成一个HashMap(底层hash后存入一个数组中),所有的Value组成一个Collection
	HashMap是将 Key做 Hash算法，然后将 Hash值映射到内存地址，直接取得 Key所对应的数据。
	在 HashMap中，底层数据结构使用的是数组，Entry<K,V>[]所谓的内存地址即数组的下标索引。
	因此具有很快的访问速度
	HashMap的高性能需要保证以下几点：
		1.Hash算法必须是高效的
		2.Hash值到内存地址 (数组索引)的算法是快速的
		3.根据内存地址 (数组索引)可以直接取得对应的值
HashMap实际上是一个链表的数组。前面已经介绍过，基于 HashMap的链表方式实现机制，
	只要HashCode()和 Hash()方法实现得足够好，能够尽可能地减少冲突的产生，
	那么对 HashMap的操作几乎等价于对数组的随机访问操作，具有很好的性能。
	但是，如果 HashCode()或者 Hash()方法实现较差，在大量冲突产生的情况下，
	HashMap事实上就退化为几个链表，对 HashMap的操作等价于遍历链表，此时性能很差。
HashMap的一个功能缺点是它的无序性，被存入到 HashMap中的元素，在遍历 HashMap时，其输出是无序的。
如果希望元素保持输入的顺序，可以使用 LinkedHashMap 替代。
线程不安全:
	任一时刻可以有多个线程同时写HashMap;可能会导致数据的不一致。
	如果需要同步，可以用 Collections的synchronizedMap方法使HashMap具有同步的能力.

随机访问HashMap get(key)实现:
	get(Object key)通过getEntry(key)获取entry然后返回entry.getValue()
	而getEntry(key)通过对key进行hash
		即:int hash =hash(key),从table[indexFor(hash, table.length)]开始
		e.next遍历对hash值是否相等然后return
		注:在JDK 1.8中实现有所修改
	HashMap通过 hash算法可以最快速地进行 Put()和 Get()操作。
	在各种Maps中HashMap用于快速查找。
效率:
	其迭代子操作时间开销和 HashMap的容量成比例:即O(n)
	因此，如果迭代操作的性能相当重要的话,不要将 HashMap的初始化容量设得过高,或者Load Factor参数设置过低。
参考:
http://blog.csdn.net/vking_wang/article/details/14166593
http://blog.csdn.net/u011202334/article/details/51496381


-------------------------------------------------------------
LinkedHashMap
	LinkedHashMap继承自 HashMap，
	具有高效性，同时在 HashMap的基础上，又在内部增加了一个链表，用以存放元素的(插入)顺序。
	LinkedHashMap是基于元素进入集合的顺序或者被访问的先后顺序排序，
	在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的.在遍历的时候会比HashMap慢。
	

WeakHashMap
WeakHashMap是一种改进的 HashMap，它对 Key实行“弱引用”
	如果一个 Key不再被外部所引用，那么此 Map会自动丢弃该值,最后该 Key可以被 GC回收。
See:WeakHashMapDemo.java
	对HashMap和WeakHashMap同时放入A,B连个对象
	当HashMap删除A,并且A,B都指向null时,WeakHashMap中A将自动被回收掉
原因:
	对于 A对象而言,当 HashMap删除并且将 A指向 Null后，
	除了 WeakHashMap中还保存 A外已经没有指向 A的指针了，所以 WeakHashMap会自动舍弃掉 a，
	而对于 B对象虽然指向了 null，但 HashMap中还有指向 B 的指针，所以 WeakHashMap 将会保留 B 对象。
	
WeakHashMap主要通过expungeStaleEntries这个函数来实现移除其内部不用的条目，从而达到自动释放内存的目的。
基本上只要对 WeakHashMap的内容进行访问就会调用这个函数，从而达到清除其内部不再为外部引用的条目。
但是如果预先生成了 WeakHashMap，而在 GC以前又不曾访问该 WeakHashMap, 那不是就不能释放内存了吗？
See : WeakHashMapDemo.testGC
通过运行测试结果内存溢出,这就证明了:WeakHashMap这个时候并没有自动帮我们释放不用的内存。

清单 12 所示代码不会出现内存溢出问题。
Hashtable
------------------------------------------------------
Hashtable 继承 Map接口，实现了一个基于 Key-Value映射的哈希表。
任何非空（non-null）的对象都可作为 Key或者 Value。
效率:
	添加数据 Put(Key，Value)，取出数据Get(Key),这两个基本操作的时间开销为常数O(1)
	Hashtable通过 Initial Capacity和 Load Factor两个参数调整性能。
	通常缺省的 Load Factor 0.75 较好地实现了时间和空间的均衡。
	增大 Load Factor 可以节省空间但相应的查找时间将增大，会影响像 Get 和 Put 这样的操作。
使用 Hashtable的简单示例:See HashTableDemo.txt


TreeMap
	TreeMap则提供了一种完全不同的 Map实现。从功能上讲，
	TreeMap有着比 HashMap更为强大的功能，它实现了 SortedMap接口，这意味着它可以对元素进行排序。
TreeMap的性能略微低于 HashMap。
	如果在开发中需要对元素进行排序，那么使用 HashMap便无法实现这种功能，
	使用 TreeMap的迭代输出将会以元素顺序进行。
TreeMap是基于元素的固有顺序 (由 Comparator或者 Comparable确定)。
	当用Iterator遍历TreeMap时，得到的记录是排过序的。

参考:
http://www.ibm.com/developerworks/cn/java/j-lo-set-operation/index.html






















