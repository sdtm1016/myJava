package base.extend.abs;

public abstract class APerson {
	public abstract void say();
}

class Chinese extends APerson {
	public void say() {
		System.out.println("说中国话");
	}
}

class American extends APerson {
	public void say() {
		System.out.println("say in english");
	}
}

class Test {
	public static void main(String[] args) {
		APerson p = new Chinese();
		APerson p2 = new American();
		p.say();
		p2.say();
	}
}
