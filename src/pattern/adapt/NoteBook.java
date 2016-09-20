package pattern.adapt;


public class NoteBook {
	//NoteBook私有ThreePlugIf(三孔接口)
	private ThreePlugIf plug;
	public NoteBook(ThreePlugIf plug){
		this.plug = plug;
	}
	//NoteBook.charge使用ThreePlugIf.powerWithThree
	public void charge(){
		plug.powerWithThree();
	}
	
	public static void main(String[]args){
		//现在只有GBTwoPlug,双孔插座
		GBTwoPlug two = new GBTwoPlug();
		//三孔接口需要三转二适配器
		
		//方法1:TwoPlugAdapter使用复合继承实现
		ThreePlugIf three = (ThreePlugIf) new TwoPlugAdapter(two);
		//NoteBook使用三孔接口充电
		NoteBook nb = new NoteBook(three);
		nb.charge();
		
		//方法2:TwoPlugAdapterExtends使用双继承实现
		three = new TwoPlugAdapterExtends();
		nb = new NoteBook(three);
		nb.charge();
		
	}
}
