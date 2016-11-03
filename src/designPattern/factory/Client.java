package designPattern.factory;

import designPattern.factory.interfaces.Boy;
import designPattern.factory.interfaces.Girl;

public class Client {

	public static void main(String[] args) {

		PersonFactory factory;
		
		factory= new HNFactory();
		Girl girl = factory.getGirl();
		
		factory = new MCFactory();
		Boy boy = factory.getBoy();
		
		girl.draw();
		boy.draw();
		
		//Person p1 = new HNFactory().getGirl();
	}

}