为什么要用线程池:
	减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务
	可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为因为消耗过多的内存，
	而把服务器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机) 

Java里面线程池的顶级接口是Executor，
	但是严格意义上讲Executor并不是一个线程池，而只是一个执行线程的工具。
	真正的线程池接口是ExecutorService。下面这张图完整描述了线程池的类体系结构。

标记一下比较重要的类：
	ExecutorService: 真正的线程池接口。
	ScheduledExecutorService: 能和Timer/TimerTask类似，解决那些需要任务重复执行的问题。
	ThreadPoolExecutor: ExecutorService的默认实现。
	ScheduledThreadPoolExecutor:
		继承ThreadPoolExecutor的ScheduledExecutorService接口实现，周期性任务调度的类实现。


要配置一个线程池是比较复杂的，尤其是对于线程池的原理不是很清楚的情况下，很有可能配置的线程池不是较优的，
因此在Executors类里面提供了一些静态工厂，生成一些常用的线程池。

    newSingleThreadExecutor：创建一个单线程的线程池。这个线程池只有一个线程在工作，
		也就是相当于单线程串行执行所有任务。
		如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
		此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
	newFixedThreadPool：创建固定大小的线程池。
    	每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
    	线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
    newCachedThreadPool：创建一个可缓存的线程池。
    	如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，
    	当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
    	此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
    newScheduledThreadPool：创建一个大小无限的线程池。
    	此线程池支持定时以及周期性执行任务的需求。
    newSingleThreadExecutor：创建一个单线程的线程池。
    	此线程池支持定时以及周期性执行任务的需求。 

那我个人感觉就是new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEPALIVE_TIME, TIME_UNIT, workQueue, rejectedExecutionHandler)；
提供了更定制化的线程池制造方法。
	因为newFixedThreadPool方法其实也是return new ThreadPoolExecutor 


java.util.concurrent.Executors类的API提供大量创建连接池的静态方法：
	1.固定大小的线程池：
		See:JavaThreadPool 
	2.单任务线程池：
		//创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。 
		ExecutorService pool = Executors.newSingleThreadExecutor(); 

 对于以上两种连接池，大小都是固定的，
	当要加入的池的线程(或者任务)超过池最大尺寸时候，则入此线程池需要排队等待。
	一旦池中有线程完毕，则排队等待的某个线程会入池执行。

[2]中还介绍了：
	3.可变尺寸的线程池newChahedThreadPool；
	4.延迟连接池；
	5.单任务延迟连接池；
	6.自定义线程池


参考:
http://www.cnblogs.com/www-35java-com/archive/2010/12/31/1923495.html











