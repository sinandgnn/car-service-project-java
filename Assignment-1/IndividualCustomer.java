class IndividualCustomer extends Customer {
	private final String T_C_Number;

	public IndividualCustomer(String name, String phoneNumber, String T_C_Number) {
		super(name, phoneNumber);
		this.T_C_Number = T_C_Number;
	}

	@Override
	public String toString() {
		return "Individual: " + name + "\n" +
				"T.C. Number: " + T_C_Number + "\n" +
				"Phone Number: " + phoneNumber + "\n";
	}
}