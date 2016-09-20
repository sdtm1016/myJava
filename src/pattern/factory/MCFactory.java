package pattern.factory;

import pattern.factory.impl.MCBoy;
import pattern.factory.impl.MCGirl;
import pattern.factory.interfaces.Boy;
import pattern.factory.interfaces.Girl;


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