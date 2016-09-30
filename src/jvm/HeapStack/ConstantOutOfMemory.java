package jvm.HeapStack;

import java.util.ArrayList;
import java.util.List;
//-verbose:gc -XX:+PrintGCDetails
//运行时常量池
public class ConstantOutOfMemory {

	public static void main(String[] args) {
		try {
			List<String> stringList = new ArrayList<String>();
			int item = 0;
			while (true) {
				stringList.add(String.valueOf(item++).intern());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
