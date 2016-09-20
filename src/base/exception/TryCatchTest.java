package base.exception;

public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method
		TryCatchTest tct = new TryCatchTest();
		int result = tct.test();
		System.out.println("test()方法执行完毕，返回值为：" + result);
		int result2 = tct.test2();
		System.out.println("我想大声告诉你！test2()的值是：" + tct.test2());

	}

	public int test() {
		int divider = 10;
		int result = 100;
		try {
			while (divider > -1) {
				divider--;
				result = result + 100 / divider;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常了！！");
			return -1;
		}

	}

	public int test2() {
		int divider = 10;
		int result = 100;
		try {
			while (divider > -1) {
				divider--;
				result = result + 100 / divider;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常了！！");
			return result = 999;
		} finally {
			System.out.println("这是finally！！！");
			System.out.println("我是Result，我的值是:" + result);
		}

	}

}
