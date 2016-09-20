package base.exception;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test ct = new Test();
		try {
			ct.test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test1() throws DrunkException {
		throw new DrunkException("喝酒不要开车");
	}

	public void test2() {
		try {
			test1();
		} catch (DrunkException e) {
			RuntimeException re = new RuntimeException(e);
			throw re;
		}
	}
}
