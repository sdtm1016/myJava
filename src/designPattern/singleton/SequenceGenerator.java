package designPattern.singleton;

import java.util.HashMap;

enum SingleTon4 {
	ONE;

	public SingleTon4 getSequence() {
		return ONE;
	}
}

public class SequenceGenerator {
	private int count = 0;

	public synchronized int getSequence() {
		++count;
		return count;
	}

	private SequenceGenerator() {
	}

	private final static SequenceGenerator instance = new SequenceGenerator();

	public static SingleTon4 getInstance() {
		return SingleTon4.ONE;
	}

}

class MemoryDao {
	private HashMap map = new HashMap();

	public void add(SingleTon4 single) {
		map.put(SequenceGenerator.getInstance().getSequence(), single);
	}

	//把MemoryDao变成单例
}
