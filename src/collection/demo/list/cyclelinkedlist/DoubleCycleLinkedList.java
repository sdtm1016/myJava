package collection.demo.list.cyclelinkedlist;

import collection.demo.list.MyList;

public class DoubleCycleLinkedList implements MyList {
	Node head; // 头指针
	Node current;// 当前结点对象
	int size;// 结点个数
	public DoubleCycleLinkedList(){
		//初始化头结点，让头指针指向头结点。并且让当前结点对象等于头结点。
		this.head = current = new Node(null);
		this.size =0;
		this.head.next =this.head;
		this.head.prior=this.head;
	}
	//定位函数，实现当前操作对象的前一个结点，也就是让当前结点对象定位到要操作结点的前一个结点。
	public void index(int index) throws Exception{
		if(index<-1||index>this.size-1){
			throw new Exception("参数错误！");
		}
		if(index==-1){
			return;
		}
		this.current=this.head.next;
		int j=0;
		while(this.current!=this.head&&j<index){
			this.current=this.current.next;
			j++;
		}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;
	}

	@Override
	public void add(int index, Object obj) throws Exception {
		// TODO Auto-generated method stub
		if (index < 0 || index > this.size) {
			throw new Exception("参数错误！");
		}
		this.index(index - 1);
		this.current.setNext(new Node(obj, this.current.next));
		this.current.next.setPrior(this.current);
		this.current.next.next.setPrior(this.current.next);
		this.size++;
	}

	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub
		// 判断链表是否为空
		if (isEmpty()) {
			throw new Exception("链表为空，无法删除！");
		}
		if (index < 0 || index > size) {
			throw new Exception("参数错误！");
		}
		this.index(index-1);
		this.current.setNext(this.current.next.next);
		this.current.next.setPrior(current);
		this.size--;
	}

	@Override
	public Object get(int index) throws Exception {
		// TODO Auto-generated method stub
		if(index <-1 || index >size-1)
		{
			throw new Exception("参数非法！");
		}
		this.index(index);

		return this.current.getElement();
	}
}