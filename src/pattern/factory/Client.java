package pattern.factory;

import pattern.factory.interfaces.Boy;
import pattern.factory.interfaces.Girl;

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