package collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
	public static void main(String[] args) {

		//autoClear();
		//testGC();
		testGC2();
	}

	public static void autoClear() {
		String a = new String("a");
		String b = new String("b");
		Map<String, String> weakmap = new WeakHashMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();

		map.put(a, "aaa");
		map.put(b, "bbb");
		weakmap.put(a, "aaa");
		weakmap.put(b, "bbb");

		// 使new String("a")不再被外部引用
		// hashmap删除a并且将a指向null
		map.remove(a);
		a = null;
		// 将b引用指向null后,new String("b")仍然还被hashmap引用
		b = null;
		System.gc();// 强制gc

		Iterator<Entry<String, String>> i = map.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry<String, String> en = (Map.Entry<String, String>) i.next();
			System.out.println("map:" + en.getKey() + ":" + en.getValue());
		}

		// 由于weakmap的key a已经为null,且没有被外部应用,weakmap自动丢弃a对应的Entry,gc后遍历
		Iterator<Entry<String, String>> j = weakmap.entrySet().iterator();
		while (j.hasNext()) {
			Map.Entry<String, String> en = (Map.Entry<String, String>) j.next();
			System.out.println("weakmap:" + en.getKey() + ":" + en.getValue());
		}
	}

	public static void testGC() {
		// 使用List保存WeakHashMap对象,WeakHashMap保存二维字节数组的kv对
		List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
		// for循环产生WeakHashMap实例,并保存在List中
		for (int i = 0; i < 1000; i++) {
			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
			d.put(new byte[1000][1000], new byte[1000][1000]);
			maps.add(d);
			// 每次循环都强制gc前不曾访问WeakHashMap
			// 访问会调用expungeStaleEntries,然后释放没有引用的对象
			System.gc();
			// 标准错误输出
			System.err.println(i);
		}

	}

	public static void testGC2() {
		List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
		for (int i = 0; i < 1000; i++) {
			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
			d.put(new byte[1000][1000], new byte[1000][1000]);
			maps.add(d);
			System.gc();
			System.err.println(i);
			// 每次循环中,遍历list访问WeakHashMap,这将在下次循环的gc时,丢弃WeakHashMap中对象
			for (int j = 0; j < i; j++) {
				System.err.println(j + " size" + maps.get(j).size());
			}
		}

	}
}
