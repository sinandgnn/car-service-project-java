abstract class Car {
	protected String brand;
	protected String model;
	protected String segment;
	protected String transmissionType;
	protected int trunkCapacity;
	protected String color;
	protected int age;
	protected String fuelType;
	protected double dailyRentalPrice;
	protected double monthlyRentalPrice;
	protected boolean isAvailable = true;
	protected RentalType rentalType;

	public enum RentalType {
		DAILY,
		MONTHLY
	}

	public Car(String brand, String model, String segment, String transmissionType, int trunkCapacity, String color, int age, String fuelType, double dailyRentalPrice) {
		this.brand = brand;
		this.model = model;
		this.segment = segment;
		this.transmissionType = transmissionType;
		this.trunkCapacity = trunkCapacity;
		this.color = color;
		this.age = age;
		this.fuelType = fuelType;
		this.dailyRentalPrice = dailyRentalPrice;
	}

	public abstract void calculateMonthlyRentalPrice();

	public boolean isAvailable() {
		return isAvailable;
	}

	public String getModel() {
		return model;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public RentalType getRentalType() {
		return rentalType;
	}

	public void setRentalType(RentalType rentalType) {
		this.rentalType = rentalType;
	}

	@Override
	public String toString() {
		return "Brand: " + brand + '\n' +
				"Model: " + model + '\n' +
				"Type: " + this.getClass().getSimpleName() + '\n' +
				"Segment: " + segment + '\n' +
				"Transmission Type: " + transmissionType + '\n' +
				"Trunk Capacity: " + trunkCapacity + '\n' +
				"Color: " + color + '\n' +
				"Age: " + age + '\n' +
				"Fuel Type: " + fuelType + '\n' +
				"Daily Rental Price: " + dailyRentalPrice + '\n';
	}

	public String getBrand() {
		return brand;
	}
}
