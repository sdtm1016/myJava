package pattern.proxy.dynamic.UD;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler1 {
	private Object target;
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}
	@Override
	public void invoke(Object o, Method m) {
		try {
			m.invoke(target);
			long starttime = System.currentTimeMillis();
			System.out.println("汽车开始行使...");
			m.invoke(target);
			long endtime = System.currentTimeMillis();
			System.out.println("汽车结束行使...汽车行驶的时间是"+(endtime - starttime) + "毫秒");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}