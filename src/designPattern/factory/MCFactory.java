package designPattern.factory;

import designPattern.factory.impl.MCBoy;
import designPattern.factory.impl.MCGirl;
import designPattern.factory.interfaces.Boy;
import designPattern.factory.interfaces.Girl;


public class MCFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new MCBoy();
	}

	@Override
	public Girl getGirl() {
		return new MCGirl();
	}



}