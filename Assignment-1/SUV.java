public class SUV extends Car {


	public SUV(String brand, String model, String segment, String transmissionType, int trunkCapacity, String color, int age, String fuelType, double dailyRentalPrice) {
		super(brand, model, segment, transmissionType, trunkCapacity, color, age, fuelType, dailyRentalPrice);
	}

	@Override
	public void calculateMonthlyRentalPrice() {
		return;
	}
}
