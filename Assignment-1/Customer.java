abstract class Customer {
	protected String name;
	protected String phoneNumber;

	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}
}
