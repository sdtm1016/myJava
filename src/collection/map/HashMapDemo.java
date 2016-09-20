package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//HashMap嵌套练习
public class HashMapDemo {

	public static void main(String[] args) {
		// 班级集合<classId,<stuId,stuName>>
		Map<Integer, Map<String, String>> classes = new HashMap<Integer, Map<String, String>>();
		// 名单集合<学生id,学生name>
		Map<String, String> names = null;
		int no = 1;
		// 向班级集合添加班级(名单集合)
		for (int i = 1; i <= 3; i++) {
			names = new HashMap<String, String>();
			for (int j = 1; j <= 20; j++) {
				names.put(i + "." + j, "tom" + no);
				no++;
			}
			classes.put(i, names);
		}
		// EntrySet方式遍历班级集合
		for (Entry<Integer, Map<String, String>> classEntry : classes.entrySet()) {

			Integer classKey = classEntry.getKey();// 班级号
			// 遍历名单集合
			Map<String, String> values = classEntry.getValue();
			for (Entry<String, String> stuEntry : values.entrySet()) {

				String stuNo = stuEntry.getKey();// 学号
				String stuName = stuEntry.getValue();// 学生名称
				System.out.println(classKey + "班:" + stuNo + "-" + stuName);
			}
		}
		System.out.println("-----------------------------------------");
		// KeySet方式遍历集合
		for (Integer classKey : classes.keySet()) {
			// 名单集合
			Map<String, String> values = classes.get(classKey);
			for (String stuNo : values.keySet()) {
				System.out.println(classKey + "班:" + stuNo + "-" + values.get(stuNo));
			}
		}
	}
}