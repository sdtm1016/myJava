package pattern.chainRsp.handler;

import pattern.chainRsp.PriceHandler;

public class Sales extends PriceHandler {

	@Override
	public void processDiscount(float discount) {

		if (discount <= 0.05) {
			System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(),
					discount);
		} else {

			successor.processDiscount(discount);// 将参数传递给下一个对象方法中
		}
	}

}