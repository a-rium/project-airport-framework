package airport;

public class Passenger {
	private String name;
	private Wallet wallet;

	public Passenger(String name, Wallet wallet) {
		this.name = name;
		this.wallet = wallet;
	}

	public void bookFlight(FlightPackage flight) {
		System.out.println("Booking flight...");
		wallet.charge(flight.getPrice());
	}

	public String getName() {
		return name;
	}
}
