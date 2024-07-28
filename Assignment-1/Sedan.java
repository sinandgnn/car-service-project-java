public class Sedan extends Car {
	public Sedan(String brand, String model, String segment, String transmissionType, int trunkCapacity, String color, int age, String fuelType, double dailyRentalPrice) {
		super(brand, model, segment, transmissionType, trunkCapacity, color, age, fuelType, dailyRentalPrice);
		calculateMonthlyRentalPrice();
	}

	@Override
	public void calculateMonthlyRentalPrice() {
		monthlyRentalPrice = dailyRentalPrice * 30 * (97.0 / 100);
	}

	@Override
	public String toString() {
		return super.toString() + "Monthly Rental Price: " + monthlyRentalPrice + '\n';
	}
}
