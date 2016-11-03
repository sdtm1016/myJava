package designPattern.proxy.dynamic.jdk;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
// InvocationHandler是jdk动态一个代理类的实现的接口 
public class TimeHandler implements InvocationHandler {
	private Object target;
	//TimeHandler构造实例化target
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}
	/**参数：
	 * proxy 代理对象
	 * method 代理对象的方法
	 * args 方法的参数
	 * 返回值：
	 * Objecet 方法的返回值
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//根据情况，复写InvocationHandler的invoke方法，事务处理器的具体实现部分
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行使...");
		method.invoke(target);//java反射机制
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行使...行驶时间是：" + 
					(endtime - starttime) + "毫秒");
		return null;//这里的target是Car对象，方法move()没有返回值，所以为null
	}
	
	/**
	 * 动态代理实现思路
	 * 实现功能：通过Proxy的newProxyInstance返回代理对象
	 * 1.声明一段源码（动态产生代理）
	 * 2.编译源码(JDK Compiler API),产生新的类（代理类）
	 * 3.将这个类load到内从当中，产生一个新的对象（代理对象）
	 * 4.return 代理对象
	 */

}