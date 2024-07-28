class CompanyCustomer extends Customer {
	private final String taxNumber;

	public CompanyCustomer(String name, String phoneNumber, String taxNumber) {
		super(name, phoneNumber);
		this.taxNumber = taxNumber;
	}

	@Override
	public String toString() {
		return "Company: " + name + "\n" +
				"Tax Number: " + taxNumber + "\n" +
				"Phone Number: " + phoneNumber + "\n";
	}
}