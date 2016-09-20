package base.extend.carRentalSystem;

public class Truck extends Car {
	private int weight;

	Truck(String name, double rent, int weight) {
		super(name, rent);
		this.weight = weight;
	}

}
