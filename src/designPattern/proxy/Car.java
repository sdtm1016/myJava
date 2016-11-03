package designPattern.proxy;


public class Car implements Moveable{

	@Override
	public void move() {
		//long starttime = System.currentTimeMillis();
		//System.out.println("汽车开始行使...");
		try {
			System.out.println("汽车行驶中...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//long endtime = System.currentTimeMillis();
		//System.out.println("汽车结束行使...行驶时间是："+(endtime-starttime)+"毫秒");
	}
	
}