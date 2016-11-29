package collection.demo.list.linkedlist;

//节点类
public class Node {
	Object element; // 数据域
	Node next; // 指针域

	//头结点的构造方法
	public Node(Node nextval) {
		this.next = nextval;
	}

	//非头结点的构造方法
	public Node(Object obj, Node nextval) {
		this.element = obj;
		this.next = nextval;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String toString() {
		return this.element.toString();
	}
}