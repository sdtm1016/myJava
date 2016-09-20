package pattern.chainRsp;
import pattern.chainRsp.handler.CEO;
import pattern.chainRsp.handler.Director;
import pattern.chainRsp.handler.Lead;
import pattern.chainRsp.handler.Manager;
import pattern.chainRsp.handler.Sales;
import pattern.chainRsp.handler.VicePresident;

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