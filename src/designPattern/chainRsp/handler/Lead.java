package designPattern.chainRsp.handler;

import designPattern.chainRsp.PriceHandler;

public class Lead extends PriceHandler {

	@Override
	public void processDiscount(float discount) {

		if (discount <= 0.15) {
			System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(),
					discount);
		} else {
			successor.processDiscount(discount);
		}
	}

}