import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	private final List<Customer> customers = new ArrayList<>();

	public void loadCustomers(String customersFile) {
		try (BufferedReader customersBR = new BufferedReader(new FileReader(customersFile))) {
			String line;
			while ((line = customersBR.readLine()) != null && !line.equals(".")) {
				if (line.startsWith("#")) {
					continue;
				}
				String[] parts = line.split(",");

				String type = parts[0];
				String name = parts[1];
				String phoneNumber = parts[2];
				String identityOrTaxNumber = parts[3];

				Customer customer = null;
				switch (type) {
					case "Individual" -> customer = new IndividualCustomer(name, phoneNumber, identityOrTaxNumber);
					case "Company" -> customer = new CompanyCustomer(name, phoneNumber, identityOrTaxNumber);
					default -> System.out.println("Unknown type: " + type);
				}

				if (customer != null)
					customers.add(customer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Customer findCustomerByName(String customerName) {
		for (Customer customer : customers) {
			if (customer.getName().equalsIgnoreCase(customerName)) {
				return customer;
			}
		}
		return null;
	}
}
