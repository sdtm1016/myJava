package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import collection.javaBean.Dog;

import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<String, Dog> map = new HashMap<String, Dog>();

		// put
		// map的key不能相同
		map.put("dog1", new Dog("", 11, ""));
		map.put("dog1", new Dog("", 11, ""));
		// map的value可以引用同一个对象
		Dog dog = new Dog("black", 11, "京巴");
		map.put("dog2", dog);
		map.put("dog3", dog);
		// map可以添加null
		map.put(null, null);
		System.out.println(map);

		// 循环map中Entry集合
		Set<Entry<String, Dog>> entries = map.entrySet();
		for (Entry<String, Dog> entry : entries) {
			String key = entry.getKey();
			Dog d = entry.getValue();
			System.out.println(key + " : " + d);
		}

		// remove没有该key,返回null
		Dog d = map.remove("dog2");
		System.out.println("map.remove(\"dog2\"): " + d);
		System.out.println("map.remove(\"dog\"): " + map.remove("dog"));
		System.out.println("map.remove(null): " + map.remove(null));// 这里比较特殊remove成功,但仍然是null
		// 循环map中key集合进行遍历
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Dog value = map.get(key);
			System.out.println(key + " : " + value);
		}

		// 练习,向HashMap中存放Person,Dog的k-v对
	}
}