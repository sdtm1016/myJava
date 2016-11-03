package designPattern.factory.impl;

import designPattern.factory.interfaces.Boy;

public class HNBoy implements Boy {

	@Override
	public void draw() {

		System.out.println("新年系类男孩");
	}

}