设计前提:
不能改或改动代价太高:类A调用接口B抽象方法b
特定情况下b的实现不能满足A,而另外的一个接口/类C的c方法却能够满足需求
要求:A能够调用到c方法
比如:M进程需要使用N进程的方法.
Adapter
方案1:设计类D双继承(D extends C implements B),实现B接口方法中调用C方法c
方案2:设计类D继承B,复合C,在实现b

符合类,继承类