package pattern.factory;

import pattern.factory.impl.HNBoy;
import pattern.factory.impl.HNGirl;
import pattern.factory.interfaces.Boy;
import pattern.factory.interfaces.Girl;

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