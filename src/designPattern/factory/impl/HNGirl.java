package designPattern.factory.impl;

import designPattern.factory.interfaces.Girl;

public class HNGirl implements Girl {

	@Override
	public void draw() {

		System.out.println("新年系列女孩");
	}

}