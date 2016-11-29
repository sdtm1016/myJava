package collection.demo.stack;

public class SequenceStack implements Stack {

	Object[] stackObj; //对象数组
	final int defaultSize =10; //默认最大长度
	int top; //栈顶位置
	int maxSize; //最大长度
	public SequenceStack(){
		this.init(this.defaultSize);
	}
	public SequenceStack(int length){
		this.init(length);
	}
	private void init(int length){
		this.maxSize=length;
		this.top=0;
		this.stackObj=new Object[length];
	}
	@Override
	public void push(Object obj) throws Exception {
		// TODO Auto-generated method stub
		if(this.top==this.maxSize){
			throw new Exception("堆栈已满！");
		}
		this.stackObj[this.top]=obj;
		this.top++;
	}

	@Override
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		if(this.isEmpty()){
			throw new Exception("堆栈为空！");
		}
		this.top--;
		return this.stackObj[this.top];
	}

	@Override
	public Object getTop() throws Exception {
		// TODO Auto-generated method stub
		return this.stackObj[this.top-1];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.top==0;
	}

}