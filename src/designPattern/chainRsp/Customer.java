package designPattern.chainRsp;

import java.util.Random;
/* 客户，请求折扣
 * 依赖于接口，工厂类，对具体实现没有耦合
 */
public class Customer {
	//价格处理人：属性封装确保只能用set访问
	private PriceHandler priceHandler;
	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
	//客户请求动作+请求参数
	public void requestDiscount(float discount){
		//交给priceHandler负责解决
		priceHandler.processDiscount(discount);
	}
	
	public static void main(String[] args) {
		//初始化
		Customer customer = new Customer();
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
		
		Random rand = new Random();
		for(int i=1;i<100;i++){
			System.out.println(i+":");
			customer.requestDiscount(rand.nextFloat());
		}
	}
}