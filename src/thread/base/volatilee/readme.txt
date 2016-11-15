java多线程-慎重使用volatile关键字

Java语言包含两种内在的同步机制：同步块（或方法）和 volatile 变量。
这两种机制的提出都是为了实现代码线程的安全性。
其中 Volatile 变量的同步性较差（但有时它更简单并且开销更低），而且其使用也更容易出错。

public volatile boolean exit = false;
在定义exit时，使用了一个Java关键字volatile，这个关键字的目的是使exit同步，也就是说在同一时刻只能由一个线程来修改exit的值.

volatile关键字用于声明简单类型变量，如int、float、boolean等数据类型。
如果这些简单数据类型声明为volatile，对它们的操作就会变成原子级别的。
但这有一定的限制。例如，下面的例子中的n就不是原子级别的：
See: ThreadVolatile.java

如果对n的操作是原子级别的，最后输出的结果应该为n=1000，而在执行上面代码时，很多时侯输出的n都小于1000，这说明n=n+1不是原子级别的操作。原因是声明为volatile的简单变量如果当前值由该变量以前的值相关，那么volatile关键字不起作用，也就是说如下的表达式都不是原子操作：
n = n + 1;
n++;
如果要想使这种情况变成原子操作，需要使用synchronized关键字，如上的代码可以改成如下的形式：

See :ThreadVolatile2.java
上面的代码将n=n+1改成了inc()，其中inc方法使用了synchronized关键字进行方法同步。因此，在使用volatile关键字时要慎重，并不是只要简单类型变量使用volatile修饰，对这个变量的所有操作都是原来操作，当变量的值由自身的上一个决定时，如n=n+1、n++等，volatile关键字将失效，只有当变量的值和自身上一个值无关时对该变量的操作才是原子级别的，如n = m + 1，这个就是原级别的。所以在使用volatile关键时一定要谨慎，如果自己没有把握，可以使用synchronized来代替volatile。