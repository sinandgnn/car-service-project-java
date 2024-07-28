import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Controller {
	private static final CarService carService = new CarService();
	private static final CustomerService customerService = new CustomerService();
	private static final RentalService rentalService = new RentalService(carService, customerService);


	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("java Controller <carsFile> <customersFile> <inputFile>");
			return;
		}

		String carsFile = args[0];
		String customersFile = args[1];
		String inputFile = args[2];

		carService.loadCars(carsFile);
		customerService.loadCustomers(customersFile);
		processCommands(inputFile);
	}

	private static void processCommands(String inputFile) {
		try (BufferedReader inputBR = new BufferedReader(new FileReader(inputFile))) {
			String line;
			while ((line = inputBR.readLine()) != null) {
				if (line.startsWith("#"))
					continue;

				String[] parts = line.split("\t");
				String command = parts[0];

				System.out.println("Command: " + line + "\n");

				switch (command) {
					case "SHOW_AVAILABLE_CARS":
						carService.showAvailableCars(parts[1]);
						break;

					case "SHOW_RENTED_CARS":
						rentalService.showRentedCars();
						break;

					case "SHOW_CUSTOMER_RENTALS":
						if (parts.length == 2) {
							rentalService.showCustomerRentals(parts[1]);
						} else {
							System.out.println("Error: Missing customer name for SHOW_CUSTOMER_RENTALS");
						}
						break;

					case "RENT_CAR":
						if (parts.length == 4) {
							rentalService.rentCar(parts[1], parts[2], parts[3]);
						} else {
							System.out.println("Error: Missing customer name or car type for RENT_CAR");
						}
						break;

					case "CANCEL_RENTAL":
						if (parts.length == 3) {
							rentalService.cancelRental(parts[1], parts[2]);
						} else {
							System.out.println("Error: Missing customer name or car type for CANCEL_RENTAL");
						}
						break;

					case "SHOW_CAR_DETAILS":
						if (parts.length == 4) {
							carService.showCarDetails(parts[1], parts[2], parts[3]);
						} else {
							System.out.println("Error: Missing car type or model for SHOW_CAR_DETAILS");
						}
						break;

					default:
						System.out.println("Error: Unknown command");
						break;
				}
				System.out.println("\n#\t#\t#\t#\t#\t#\t#\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

