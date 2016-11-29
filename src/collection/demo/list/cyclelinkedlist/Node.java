package collection.demo.list.cyclelinkedlist;

public class Node {
	Object element; // 数据域
	Node next; // 后继指针域
	Node prior; // 前驱指针域

	Node(Node nextval){
		this.next=nextval;
	}
	Node(Object obj,Node nextval){
		this.next=nextval;
		this.element=obj;
	}
	// 获得当前结点的后继结点
	public Node getNext() {
		return this.next;
	}

	// 获得当前结点的前驱结点
	public Node getPrior() {
		return this.prior;
	}

	// 获得当前的数据域的值
	public Object getElement() {
		return this.element;
	}

	// 设置当前结点的后继指针域
	public void setNext(Node nextval) {
		this.next = nextval;
	}

	// 设置当前结点的前驱指针域
	public void setPrior(Node priorval) {
		this.prior = priorval;
	}

	// 设置当前结点的数据域
	public void setElement(Object obj) {
		this.element = obj;
	}

	public String toString() {
		return this.element.toString();
	}
}