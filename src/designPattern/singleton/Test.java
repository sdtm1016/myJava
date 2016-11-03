package designPattern.singleton;

public class Test {

	public static void main(String[] args) {
		/*Singleton s1 = Singleton.instance;
		Singleton s2 = Singleton.instance;
		System.out.println(s1 == s2);*/
		
		/*Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);*/
		
		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();
		System.out.println(s3==s4);
	}
	

}