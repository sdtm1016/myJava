package base.extend.carRentalSystem;

public class PassengerCar extends Car {
	private int num;

	PassengerCar(String name, double rent, int num) {
		super(name, rent);
		this.num = num;
	}
}
