package collection.javaBean;


public class Dog implements Comparable<Dog> {
	private String colo;
	private int waight;
	private String category;

	public Dog(String colo, int waight, String category) {
		super();
		this.colo = colo;
		this.waight = waight;
		this.category = category;
	}

	public String getColo() {
		return colo;
	}

	public void setColo(String colo) {
		this.colo = colo;
	}

	public int getWaight() {
		return waight;
	}

	public void setWaight(int waight) {
		this.waight = waight;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Dog (colo=" + colo + ", waight=" + waight + ", category=" + category + ")@" + this.hashCode();
	}

	@Override
	public int compareTo(Dog o) {
		if (o == null) {
			return 1;
		}
		// 对三种属性根据等级进行比价,类似价值
		// category
		if (o.getCategory() != null) {
			if (this.category.equals(o.getCategory())) {
				// colo
				if (o.getColo() != null) {
					if (this.colo.equals(o.getColo())) {
						// waight
						return this.waight - o.getWaight();
					}
					return this.colo.compareTo(o.getColo());
				}
			}
			return this.category.compareTo(o.getCategory());
		}
		return this.getWaight();
	}

}