package base.exception;

//异常链。将异常生成一个新的异常抛出；
//test1():抛出“喝大了”异常
//test2():调用test1()，捕获“喝大了”异常，并且包装成运行时异常，继续抛出
//main():调用test2(),尝试捕获test2()方法抛出的异常
public class ChainTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChainTest ct = new ChainTest();
		try{
			ct.test2();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	public void test1() throws DrunkException{
		throw new DrunkException("喝酒别开车");
	}
	public void test2(){
		try {
			test1();
		} catch (DrunkException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//new一个RuntimeException异常newExc，含参构造器里传进去一个字符串“司机……”，
			RuntimeException newExc=new RuntimeException(e);
			//newExc.initCause(e);//将捕获test1的异常对象e传递到newExc里；显示抛出这个新异常的原始异常
			throw newExc;//抛出新的异常
		}
	}

}
