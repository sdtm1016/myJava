package collection.map;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// String value = GetValueByKey("Test.properties", "name");
		// System.out.println(value);
		// GetAllProperties("Test.properties");
		WriteProperties("file/test.properties", "long", "212");

	}

	// 关于Properties类常用的操作
	// 根据Key读取Value
	public static String GetValueByKey(String filePath, String key) {
		Properties pps = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			pps.load(in);
			String value = pps.getProperty(key);
			System.out.println(key + " = " + value);
			return value;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 读取Properties的全部信息
	public static void GetAllProperties(String filePath) throws IOException {
		Properties pps = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		pps.load(in);
		@SuppressWarnings("rawtypes")
		Enumeration en = pps.propertyNames(); // 得到配置文件的名字

		while (en.hasMoreElements()) {
			String strKey = (String) en.nextElement();
			String strValue = pps.getProperty(strKey);
			System.out.println(strKey + "=" + strValue);
		}

	}

	public static void test() throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream("file/conf.properties"));
		for (Object key : prop.keySet()) {
			Object value = prop.get(key);
			System.out.println(key + " : " + value);
		}
	}

	// 写入Properties信息
	public static void WriteProperties(String filePath, String pKey, String pValue) throws IOException {
		Properties pps = new Properties();

		// 从输入流中读取属性列表（键和元素对）
		InputStream in = new FileInputStream(filePath);
		// 以适合使用 load 方法加载到 Properties表中的格式，
		pps.load(in);
		OutputStream out = new FileOutputStream(filePath);
		// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
		// 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
		pps.setProperty(pKey, pValue);
		// 将此 Properties 表中的属性列表（键和元素对）写入输出流
		pps.store(out, "Update " + pKey + " name");
	}

	public static void systemProperties() {
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
