package pattern.template;

public class Tea extends RefreshBeverage {

	@Override
	protected void addCondiments() {
		System.out.println("加入柠檬");
	}

	@Override
	protected void brew() {
		System.out.println("用80度的热水浸泡");
	}

	/*
	 * 子类通过覆盖的性质选择挂在钩子函数
	 * 
	 * @see
	 * com.imooc.pattern.template.RefreshBeverage#isCustmerWantsCondiments()
	 */
	protected boolean isCustmerWantsCondiments() {
		return false;

	}

}