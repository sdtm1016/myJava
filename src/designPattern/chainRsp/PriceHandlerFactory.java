package designPattern.chainRsp;
import designPattern.chainRsp.handler.CEO;
import designPattern.chainRsp.handler.Director;
import designPattern.chainRsp.handler.Lead;
import designPattern.chainRsp.handler.Manager;
import designPattern.chainRsp.handler.Sales;
import designPattern.chainRsp.handler.VicePresident;

public class PriceHandlerFactory {

	//创建PriceHandler的工厂方法（这是一个具体实现的框架）
	//随着PriceHandler的子类改变而改变，应与PriceHandler（不改变）分离开
	public static PriceHandler createPriceHandler() {
		//将各种实现类向上转型到统一的接口类上，（工厂模式）
		PriceHandler sales = new Sales();
		PriceHandler lead = new Lead();
		PriceHandler man = new Manager();
		PriceHandler dir = new Director();
		PriceHandler vp = new VicePresident();
		PriceHandler ceo = new CEO();
		//设置每个对象的直接后继
		sales.setSuccessor(lead);
		lead.setSuccessor(man);
		man.setSuccessor(dir);
		dir.setSuccessor(vp);
		vp.setSuccessor(ceo);
		
		return sales;
	}

}