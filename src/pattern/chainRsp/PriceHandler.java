package pattern.chainRsp;

/*
 * 使用抽象类，来限制继承子类的固定特征，同事抽象类唯一不变
 * 价格处理人，处理客户折扣申请
 */
public abstract class PriceHandler {
	/*
	 * 直接后继，用于传递请求
	 */
	protected PriceHandler successor;

	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}

	/*
	 * 处理折扣申请
	 */
	public abstract void processDiscount(float discount);
	// 具体以子类重写方法为准
}