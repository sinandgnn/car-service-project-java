public class Hatchback extends Car {

	public Hatchback(String brand, String model, String segment, String transmissionType, int trunkCapacity, String color, int age, String fuelType, double dailyRentalPrice) {
		super(brand, model, segment, transmissionType, trunkCapacity, color, age, fuelType, dailyRentalPrice);
		calculateMonthlyRentalPrice();
	}

	@Override
	public void calculateMonthlyRentalPrice() {
		double multiplier;
		switch (segment) {
			case "A":
				multiplier = 0.85;
				break;
			case "B":
				multiplier = 0.86;
				break;
			case "C":
				multiplier = 0.89;
				break;
			case "D":
				multiplier = 0.88;
				break;
			case "E":
				multiplier = 0.91;
				break;
			case "F":
				multiplier = 0.95;
				break;
			case "J":
				multiplier = 0.87;
				break;
			case "M":
				multiplier = 0.90;
				break;
			case "S":
				multiplier = 0.94;
				break;
			default:
				multiplier = 1.0;
				break;
		}
		monthlyRentalPrice = dailyRentalPrice * multiplier * 30;
	}

	@Override
	public String toString() {
		return super.toString() + "Monthly Rental Price: " + monthlyRentalPrice + '\n';
	}
}
