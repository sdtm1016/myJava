package pattern.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	// 创建 代理类的属性
	private Enhancer enhancer = new Enhancer();

	// getProxy得到代理类
	public Object getProxy(Class clazz) {
		// 设置创建子类的类(为每个类创建代理类)
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();// 产生类的实例
	}

	/**
	 * 方法作用：拦截所有目标类方法的调用 obj 目标类的实例 m 目标方法的反射对象 args 方法的参数 proxy 代理类的实例
	 */
	@Override
	public Object intercept(Object obj, Method m, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("日志开始...");
		// 代理类调用父类方法
		proxy.invokeSuper(obj, args);
		System.out.println("日志结束...");
		return null;
	}

}