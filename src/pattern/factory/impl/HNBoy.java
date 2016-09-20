package pattern.factory.impl;

import pattern.factory.interfaces.Boy;

public class HNBoy implements Boy {

	@Override
	public void draw() {

		System.out.println("新年系类男孩");
	}

}