   Java的类加载有两个重点，一是动态加载，一是父类加载。
 动态加载是指只有首次构建某个类的对象或者访问某个类的静态方法或者静态域的时候该类才会被加载。

那么这些类在java中又是怎么被加载的呢？就是Classloader。
Java中一般有三种Classloader：
	Bootstrap Classloader,它被称为启动类加载器，它主要负责加载Java核心类，一般是指jre/lib下的jar包；
	Extended Classloader，它被称为拓展类加载器，它一般是负责加载jre/lib/ext下的jar包；
	Appclass Classloader，它被称为系统类加载器，自己定义的类一般就是由它来加载了。

Classloader自己本身也是一个类，那么它们又是有谁加载呢？
	首先，Bootstrap Classloader最先被启动，所以它并不是被加载的类，
	它一般是由操作系统语言写的（也就是c/c++/汇编这些语言），所以它是自启动的。
	Bootstrap Classloader启动后就会加载Extened Classloader，
	Extened Classloader会加载Appclass Classloader，
	前者也被称为后者的parent，但是他们并不是继承关系而是加载和被加载的关系。

那么居然知道了什么是父类加载器，那么我们就来看看什么是父类加载机制，看一段代码：
	protected synchronized Class<?> loadClass  
	  (String name, boolean resolve)  
	  throws ClassNotFoundException{  
	  // First check if the class is already loaded  
	  Class c = findLoadedClass(name);  
	  if (c == null) {  
	    try {  
	      if (parent != null) {  
	        c = parent.loadClass(name, false);  
	      } else {  
	        c = findBootstrapClass0(name);  
	      }  
	    } catch (ClassNotFoundException e) {  
	      // If still not found, then invoke  
	      // findClass to find the class.  
	      c = findClass(name);  
	    }  
	  }  
	  if (resolve) {  
	      resolveClass(c);  
	  }  
	  return c;  
	}
	
    从以上代码中可以看出，JAVA类加载的过程如下：
	1.检测此Class是否载入过（即在cache中是否有此Class），如果有到8,如果没有到2
	2.如果parent classloader不存在（没有parent，那parent一定是bootstrap classloader了），到4
	3.请求parent classloader载入（注意，这一步是递归调用，
	也就是说如果有父类，一定是从父类进行加载，这样做的好处是可以确保关键的信息不被覆盖），如果成功到8，不成功到5
	4.请求jvm从bootstrap classloader中载入，如果成功到8
	5.寻找Class文件（从与此classloader相关的类路径中寻找）。如果找不到则到7.
	6.从文件中载入Class，到8.
	7.抛出ClassNotFoundException.
	8.返回Class.

---------------------------------------------------------
java Reflect:反射
	1.java.lang.reflect
	2.java.lang.Class:类类,类描述符,描述的是外观
	3.java.lang.reflect.Method
		方法描述符,描述方法的特征
	4.java.lang.reflect.Field
		字段,描述字段的特征
		See:Student.java/BigStudent.java/TestReflect.java
	5.java.lang.reflect.Constructor
		构造器
	6.java.lang.reflect.Modifier
		修饰符
	
	














