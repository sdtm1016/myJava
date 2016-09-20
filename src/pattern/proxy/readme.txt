代理模式
按场合功能分类:
	远程代理(Remote):
	为不同地理对象提供局域网代表对象(hadoop的Rpc)
	虚拟代理(Virtual)
	根据需要讲资源消耗很大的对象进行延迟,真正需要的时候创建
	智能引用代理(Smart Reference)
	提供对目标对象额外服务,如:日志处理,权限管理,事务处理..
	保护代理(Protect):权限控制
按照原理分类:静态(继承/聚合),动态

JDK动态代理实现日志处理
ProxySubject-->Proxy-->ProxyHandler(InvocationHadler)-->RealSubject
AOP:调用者-->参数验证-->记录方法开始-->代理-->原始对象-->记录方法结束--调用者
调用者-->Proxy1{
	参数验证
	Proxy2{
		记录方法开始
		调用原始对象.function
		记录方法结束
	}
}
模拟JDK动态代理实现

定义:Adapt为对象A提供一种代理以控制A的访问,Adapt起中介作用,可去掉功能服务和增加额外服务


