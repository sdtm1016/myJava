package base.extend.carRentalSystem;

public class Pickup extends Car {
	private int num;
	private int weight;

	Pickup(String name, double rent, int num, int weight) {
		super(name, rent);
		this.weight = weight;
		this.num = num;
	}

}
