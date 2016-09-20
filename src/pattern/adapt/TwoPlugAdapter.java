package pattern.adapt;
/*Adapter，适配器
 * 二相转三相适配器
 */
public class TwoPlugAdapter implements ThreePlugIf {
	//通过构造器TwoPlugAtdapter(表示适配器)将GBTwoPlug传参
	//实现了接口ThreePlugIf，向上转型为ThreePlugIf
	//然后强制转换，即实现了对象类类型的改变
	private GBTwoPlug two;	
	public TwoPlugAdapter(GBTwoPlug two) {
		this.two = two;
	}

	@Override
	public void powerWithThree() {
		System.out.println("通过转换");
		two.powerWithTow();
	}

}