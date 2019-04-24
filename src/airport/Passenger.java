package airport;

import generic.GenericObserver;

public class Passenger implements GenericObserver<FlightNotification> {
	private String name;
	private Wallet wallet;

	public Passenger(String name, Wallet wallet) {
		this.name = name;
		this.wallet = wallet;
	}

//	public void bookFlight(FlightPackage flight) {
//		System.out.println("Booking flight...");
//		wallet.charge(flight.getPrice());
//	}
//
	public String getName() {
		return name;
	}
	
	public boolean pay(double amount) {
		return wallet.charge(amount);
	}

	@Override
	public void update(FlightNotification notification) {
		Flight flight = notification.getFlight();
		String origin = flight.getOrigin();
		String destination = flight.getDestination();
		
		System.out.printf("%s received a notification relative to the flight %s -> %s saying: %s\n", name, origin, destination, notification.getMessage());
	}
}
