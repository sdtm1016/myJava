package collection.demo.stack.linkedstack;

import collection.demo.stack.Stack;

public class LinkedStack implements Stack {
	Node head;  //栈顶指针
	int size;  //结点的个数
	public LinkedStack(){
		this.head=null;
		this.size=0;
	}
	@Override
	public void push(Object obj) throws Exception {
		// TODO Auto-generated method stub
		this.head=new Node(obj,this.head);
		this.size++;
	}

	@Override
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		if(this.isEmpty()){
			throw new Exception("栈为空！");
		}
		Object obj=this.head.getElement();
		this.head=this.head.next;
		return obj;
	}

	@Override
	public Object getTop() throws Exception {
		// TODO Auto-generated method stub
		return this.head.getElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.head==null;
	}

}