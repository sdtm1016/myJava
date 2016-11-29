package collection.demo.stack;

public interface Stack {
	// 入栈
	public void push(Object obj) throws Exception;

	// 出栈
	public Object pop() throws Exception;

	// 获得栈顶元素
	public Object getTop() throws Exception;

	// 判断栈是否为空
	public boolean isEmpty();
}