package pattern.factory;

import pattern.factory.interfaces.Boy;
import pattern.factory.interfaces.Girl;

public interface PersonFactory {

	public Boy getBoy();
	public Girl getGirl();
}
