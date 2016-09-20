package pattern.proxy.dynamic.UD;
/**
 * 动态代理实现思路
 * 实现功能：通过Proxy的newProxyInstance返回代理对象
 * 1.声明一段源码（动态产生代理）
 * 2.编译源码(JDK Compiler API),产生新的类（代理类）
 * 3.将这个类load到内从当中，产生一个新的对象（代理对象）
 * 4.return 代理对象
 */
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

//用于生成$Proxy类代码
public class Proxy1 {

	public static Object newProxyInstance(Class infce, InvocationHandler1 h)
			throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//源代码部分
		String rt = "\r\n";
		String methodStr = "";
		for (Method m : infce.getMethods()) {
			methodStr = "	@Override" + rt + 
					"	public void " + m.getName() + "() {" + rt + 
					"try{" + rt+ 
					"	Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt
					+ "	h.invoke(this,md);" + rt + 
					"}catch(Exception e){e.printStackTrace();}" + rt + 
					"	}";

		}

		String str = "package com.imooc.jdkproxyTest;" + rt + 
				"import java.lang.reflect.Method;" + rt+ 
				"import com.imooc.jdkproxyTest.InvocationHandler;" + rt + 
				"public class $Proxy0 implements " + infce.getName() + " {" + rt + 
				"	public $Proxy0(InvocationHandler h) {" + rt + 
				"		super();" + rt+ 
				"		this.h = h;" + rt + 
				"	}" + rt + 
				" private InvocationHandler h;" + rt + methodStr + "}";
		// 产生代理类的java文件
		String filename = System.getProperty("user.dir") + "/bin/com/imooc/jdkproxyTest/$Proxy0.java";
		File file = new File(filename);
		FileUtils.writeStringToFile(file, str);
		// System.out.println(filename);

		// 编译
		// 1.拿到编译器
		JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = complier.getStandardFileManager(null, null, null);
		// 获取文件
		Iterable units = fileMgr.getJavaFileObjects(filename);
		// 编译任务
		CompilationTask t = complier.getTask(null, fileMgr, null, null, null, units);
		// 进行编译
		t.call();
		fileMgr.close();

		// load 到内存中
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class c = cl.loadClass("com.imooc.jdkproxyTest.$Proxy0");
		// System.out.println(c.getName());

		Constructor ctr = c.getConstructor(InvocationHandler1.class);
		return ctr.newInstance(h);
	}

}