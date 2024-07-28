import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CarService {
	private List<Car> cars = new ArrayList<>();

	public void loadCars(String carsFile) {
		try (BufferedReader carsBR = new BufferedReader(new FileReader(carsFile))) {
			String line;
			while ((line = carsBR.readLine()) != null && !line.equals(".")) {
				if (line.startsWith("#"))
					continue;

				String[] details = line.split(",");
				String type = details[0];
				String brand = details[1];
				String model = details[2];
				String segment = details[3];
				String transmissionType = details[4];
				int trunkCapacity = Integer.parseInt(details[5]);
				String color = details[6];
				int age = Integer.parseInt(details[7]);
				String fuelType = details[8];
				double dailyRentalPrice = Double.parseDouble(details[9]);

				Car car = null;
				switch (type) {
					case "Sedan" ->
							car = new Sedan(brand, model, segment, transmissionType, trunkCapacity, color, age, fuelType, dailyRentalPrice);
					case "Hatchback" ->
							car = new Hatchback(brand, model, segment, transmissionType, trunkCapacity, color, age, fuelType, dailyRentalPrice);
					case "SUV" ->
							car = new SUV(brand, model, segment, transmissionType, trunkCapacity, color, age, fuelType, dailyRentalPrice);
					default -> System.out.println("Unknown type: " + type);
				}

				if (car != null) {
					cars.add(car);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showAvailableCars(String customerType) {
		System.out.println("SHOWING AVAILABLE CARS FOR " + customerType.toUpperCase() + " CUSTOMER\n");
		for (Car car : cars) {
			if (car.isAvailable()) {
				if (customerType.equalsIgnoreCase("INDIVIDUAL") && car.getClass().getSimpleName().equalsIgnoreCase("SUV")) {
					continue;
				}
				System.out.println(car);
			}
		}
	}

	public void showCarDetails(String carType, String brand, String model) {
		System.out.println("SHOWING DETAILS FOR CAR: " + carType + " " + brand + " " + model);
		for (Car car : cars) {
			if (car.getClass().getSimpleName().equalsIgnoreCase(carType) && car.getBrand().equalsIgnoreCase(brand) && car.getModel().equalsIgnoreCase(model)) {
				System.out.println(car);
				return;
			}
		}
		System.out.println("Error: No car found with type " + carType + " " + brand + " " + model);
	}

	public Car findAvailableCar(String carType) {
		for (Car car : cars) {
			if (car.isAvailable() && car.getClass().getSimpleName().equalsIgnoreCase(carType)) {
				return car;
			}
		}
		return null;
	}

	public void setCarUnavailable(Car car) {
		car.setAvailable(false);
	}

	public void setCarAvailable(Car car) {
		car.setAvailable(true);
	}
}
