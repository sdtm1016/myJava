package pattern.proxy.dynamic.UD;

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

import pattern.proxy.Car;

public class Proxy2 {

	public static Object newProxyInstance(Class infce) throws IOException,
			ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		String rt = "\r\n";
		String methodStr = "";
		for (Method m : infce.getMethods()) {
			methodStr = "	@Override" + rt + "	public void " + m.getName()
					+ "() {" + rt
					+ "		long starttime = System.currentTimeMillis();" + rt
					+ "		System.out.println(\"汽车开始行使...\");" + rt + "		m."
					+ m.getName() + "();" + rt
					+ "		long endtime = System.currentTimeMillis();" + rt
					+ "		System.out.println(\"汽车结束行使...行驶时间是：\" + " + rt
					+ "					(endtime - starttime) + \"毫秒\");" + rt + "	}";
		}

		String str = "package com.imooc.jdkproxyTest;" + rt
				+ "public class $Proxy0 implements " + infce.getName() + " {"
				+ rt + "	private " + infce.getName() + " m;" + rt
				+ "	public $Proxy0(" + infce.getName() + " m) {" + rt
				+ "		super();" + rt + "		this.m = m;" + rt + "	}" + rt
				+ methodStr + "}"; // 产生代理类的java文件
		String filename = System.getProperty("user.dir")
				+ "/bin/com/imooc/jdkproxyTest/$Proxy0.java";
		File file = new File(filename);
		FileUtils.writeStringToFile(file, str);
		// System.out.println(filename);

		// 编译
		// 1.拿到编译器
		JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = complier.getStandardFileManager(null,
				null, null);
		// 获取文件
		Iterable units = fileMgr.getJavaFileObjects(filename);
		// 编译任务
		CompilationTask t = complier.getTask(null, fileMgr, null, null, null,units);
		// 进行编译
		t.call();
		fileMgr.close();

		// load 到内存中
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class c = cl.loadClass("com.imooc.jdkproxyTest.$Proxy0");
		// System.out.println(c.getName());

		Constructor ctr = c.getConstructor(infce);
		return ctr.newInstance(new Car());

	}
}
