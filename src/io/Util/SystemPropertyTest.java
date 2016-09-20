package io.Util;

import java.util.Properties;
import java.util.Set;

public class SystemPropertyTest {

	public static void main(String[] args) {
		// Hashtable类型
		Properties p = System.getProperties();
		Set<Object> set = p.keySet();
		// Iterator<Object> it = set.iterator();
		for (Object obj : set) {
			String v = p.getProperty((String) obj);
			System.out.println(obj + "\t" + v);
		}

		// win7系统行分隔符:seq为特殊字符\r\n,无法打印
		String sep = System.getProperty("line.separator");
		// String str = java.security.AccessController.doPrivileged(
		// new sun.security.action.GetPropertyAction("line.separator"));

		System.out.println(sep.length()); // 2
		// char s1 = sep.charAt(0); // 13
		// s1 = sep.charAt(1); // 10

		// \r和\n在java中作用都是换行
		System.out.print("word1\r");
		System.out.print("word2\n");
		// \r\n仍然是换一次行,这里是win系统换行newLine()
		System.out.print("word3\r\n");
		// \n\r就会两次换行
		System.out.print("word4\n\r");
		// println方法是print()+newLine()
		System.out.println("word5");
	}
}
