package designPattern.factory;

import designPattern.factory.impl.HNBoy;
import designPattern.factory.impl.HNGirl;
import designPattern.factory.interfaces.Boy;
import designPattern.factory.interfaces.Girl;

public class HNFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new HNBoy();
	}

	@Override
	public Girl getGirl() {
		return new HNGirl();
	}

}