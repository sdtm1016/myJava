package collection.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import collection.javaBean.Dog;
import collection.javaBean.DogDetialInfo;

//实现排序
public class TreeMapDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Map<Dog, DogDetialInfo> map = new TreeMap<Dog, DogDetialInfo>();

		Dog d1 = new Dog("grey", 13, "哈士奇");
		Dog d2 = new Dog("while", 11, "京巴");
		Dog d3 = new Dog("black", 10, "贵宾犬");
		Dog d4 = new Dog("yellow", 16, "藏獒");
		Dog d5 = new Dog("yellow", 15, "藏獒");

		map.put(d1, new DogDetialInfo(d1));
		map.put(d2, new DogDetialInfo(d2));
		map.put(d3, new DogDetialInfo(d3));
		map.put(d4, new DogDetialInfo(d4));
		map.put(d5, new DogDetialInfo(d5));

		Map map1 = ((TreeMap) map).subMap(d2, d4);
		for (Iterator iterator = map1.keySet().iterator(); iterator.hasNext();) {
			Dog key = (Dog) iterator.next();
			System.out.println(key + "->" + map.get(key));
		}
		System.out.println("subMap end");

		// 打印分数比d1 差的狗
		map1 = ((TreeMap) map).headMap(d1);
		for (Iterator iterator = map1.keySet().iterator(); iterator.hasNext();) {
			Dog key = (Dog) iterator.next();
			System.out.println(key + "->" + map.get(key));
		}
		System.out.println("subMap end");

		// 打印比 d1好的狗
		map1 = ((TreeMap) map).tailMap(d1);
		for (Iterator iterator = map1.keySet().iterator(); iterator.hasNext();) {
			Dog key = (Dog) iterator.next();
			System.out.println(key + "->" + map.get(key));
		}
		System.out.println("subMap end");
	}

}
