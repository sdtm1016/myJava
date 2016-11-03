package designPattern.factory;

import designPattern.factory.interfaces.Boy;
import designPattern.factory.interfaces.Girl;

public interface PersonFactory {

	public Boy getBoy();
	public Girl getGirl();
}
