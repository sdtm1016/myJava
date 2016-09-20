Set
------------------------------------------------------------
Set是一种不包含重复的元素的 Collection，即任意的两个元素 e1和 e2都有 e1.equals(e2)=false。
Set最多有一个 null 元素。很明显，Set 的构造函数有一个约束条件，传入的 Collection 参数不能包含重复的元素
请注意，必须小心操作可变对象（Mutable Object），如果一个 Set中的可变元素改变了自身状态，这可能会导致一些问题。

HashSet:线程不安全,存取速度快
	Set集合中不能存放重复元素,(注意这里的意思是:跟同一个对象无关,指的是不同元素但hashcode和equals都相同)
hash散列机制:
	数据在内存中可分布在多个空间(桶概念)
	hash将数据的特定属性进行hash得到值后取模(比如0-9个空间,取模后的值为n则该数据在第n个空间)
	hash把对象的信息经过一些转变形成一个独一无二的int值，并存储在数组 Entry<K,V>[]中
	访问可以通过在array中快速获取该值并迅速访问到对应的空间,然后通过数据比对就找到对应的元素
	Set使用会先判断hashcode是否相同,不同则存放,相同则再判断equals
	hashcode在Object中实现是直接返回内存地址
关于:hashcode,equals和==
	hashcode在Object中是native方法,调用了系统动态库(c文件),默认为数据的物理地址的int值
	另外:
		通过打印一个没有复写toString方法的对象,可以复写hashcode方法
		返回结果如:Person@1c15c,其中@后面的值为hashcode的值
	equals是在Object中调用的是==,==判断是直接调用内存空间地址;
	那么在向Set中添加重写了equals方法的对象时,要注意hashcode是否需要重写因为存在情况:
	如果equals相同,由于没有重写hashcode,默认hashcode不同,导致Set添加成功,这是程序设计所不愿的
	HashSet的add添加通过 HashMap的map.put(e, PRESENT)实现,具体是对key取hash
	remove通过遍历元素判断比较hashcode和equals,然后删除
	See: HashSetDemo.java

LinkedHashSet:
	 具有HashSet的查询速度，且内部使用链表维护元素的顺序(插入的次序)。
	 于是在使用迭代器遍历Set时，结果会按元素插入的次序显示。

	
TreeSet:线程安全,可以对Set集合中元素进行排序
TreeSet能够维护其内元素的升序状态:
	TreeSet对元素add使用NavigableMap.put方法,这要求元素对象要可比较性
	关于Comparator和Comparable用法See TreesetDemo.java
比较:
	对比HashSet:
	HashSet通常优于TreeSet(插入、查找)
	只有当需要产生一个经过排序的序列，才用TreeSet。
	对比ArrayList:
	1.在对大量信息进行检索的时候，TreeSet比ArrayList更有效率，能保证在log(n)的时间内完成
	2.TreeSet是实用树形结构来存储信息的，每个节点都会保存一下指针对象，分别指向父节点，左分支，右分支，
	相比较而言，ArrayList就是一个含有元素的简单数组了，正因为如此，它占的内存也要比ArrayList多一些。
	3.向TreeSet插入元素也比ArrayList要快一些，
	因为当元素插入到ArrayList的任意位置时，平均每次要移动一半的列表，需要O(n)的时间，
	而TreeSet深度遍历查询花费的实施只需要O(log(n))
	(普遍的都是，set查询慢，插入快，list查询快，插入慢)）

思考:
HashMap内部实现原理,HashSet和HashMap区别
HashTable线程安全,性能差一些