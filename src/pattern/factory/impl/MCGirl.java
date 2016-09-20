package pattern.factory.impl;
import pattern.factory.interfaces.Girl;

public class MCGirl implements Girl {

	@Override
	public void draw() {

		System.out.println("圣诞系女孩");
	}

}