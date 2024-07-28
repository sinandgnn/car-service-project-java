import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalService {
	private Map<Customer, List<Car>> carsOfCustomer = new HashMap<>();
	private CarService carService;
	private CustomerService customerService;

	public RentalService(CarService carService, CustomerService customerService) {
		this.carService = carService;
		this.customerService = customerService;
	}

	public void showRentedCars() {
		System.out.println("SHOWING RENTED CARS\n");
		boolean isThereRentedCar = false;
		for (Map.Entry<Customer, List<Car>> entry : carsOfCustomer.entrySet()) {
			for (Car car : entry.getValue()) {
				if (!car.isAvailable()) {
					System.out.println(car.getRentalType() + " RENTED CAR");
					System.out.println(car);
					isThereRentedCar = true;
				}
			}
		}
		if (!isThereRentedCar) {
			System.out.println("There is no rented car.");
		}
	}

	public void showCustomerRentals(String customerName) {
		System.out.println("SHOWING RENTALS FOR CUSTOMER: " + customerName + "\n");
		Customer foundCustomer = customerService.findCustomerByName(customerName);

		if (foundCustomer == null) {
			System.out.println("Customer not found: " + customerName);
		} else {
			List<Car> rentedCars = carsOfCustomer.get(foundCustomer);
			if (rentedCars != null && rentedCars.size() != 0) {
				for (Car rentedCar : rentedCars) {
					System.out.println(rentedCar);
				}
			} else {
				System.out.println("No rentals found for customer: " + customerName);
			}
		}
	}

	public void rentCar(String customerName, String carType, String rentalString) {
		System.out.println("RENTING CARS");
		Customer rentingCustomer = customerService.findCustomerByName(customerName);
		Car.RentalType rentalType = rentalString.equalsIgnoreCase("DAILY") ? Car.RentalType.DAILY : Car.RentalType.MONTHLY;

		if (rentingCustomer == null) {
			System.out.println("Error: Customer not found");
			return;
		}

		if (rentingCustomer instanceof IndividualCustomer) {
			if (carType.equalsIgnoreCase("SUV")) {
				System.out.println("Error: Individual customers can only rent Hatchback and Sedan cars");
				return;
			}
		}

		if (carType.equalsIgnoreCase("SUV") && rentalString.equals("MONTHLY")) {
			System.out.println("Error: SUV cars can only rent daily.");
			return;
		}

		Car carToRent = carService.findAvailableCar(carType);

		if (carToRent == null) {
			System.out.println("Error: No available cars of type " + carType);
			return;
		}

		carToRent.setRentalType(rentalType);
		carService.setCarUnavailable(carToRent);

		List<Car> rentedCars = carsOfCustomer.computeIfAbsent(rentingCustomer, k -> new ArrayList<>());
		rentedCars.add(carToRent);

		System.out.println("Car " + carToRent.getRentalType() + " rented successfully: \n" + carToRent);
		System.out.println("Customer: \n" + rentingCustomer);
	}

	public void cancelRental(String customerName, String carType) {
		System.out.println("CANCELING RENTAL");
		Customer cancelingCustomer = customerService.findCustomerByName(customerName);

		if (cancelingCustomer == null) {
			System.out.println("Error: Customer not found");
			return;
		}

		List<Car> rentedCars = carsOfCustomer.get(cancelingCustomer);
		if (rentedCars == null || rentedCars.isEmpty()) {
			System.out.println("Error: No rentals found for customer: " + customerName);
			return;
		}

		Car carToCancel = null;
		for (Car car : rentedCars) {
			if (car.getClass().getSimpleName().equalsIgnoreCase(carType)) {
				carToCancel = car;
				break;
			}
		}

		if (carToCancel == null) {
			System.out.println("Error: No rental found for customer: " + customerName + " with car type: " + carType);
			return;
		}

		carService.setCarAvailable(carToCancel);
		carToCancel.setRentalType(null);
		rentedCars.remove(carToCancel);
		if (rentedCars.isEmpty()) {
			carsOfCustomer.remove(cancelingCustomer);
		}
		System.out.println("Rental canceled successfully: " + carToCancel);
	}
}