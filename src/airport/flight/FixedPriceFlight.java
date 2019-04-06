package airport.flight;

import airport.Aircraft;
import airport.Flight;
import airport.FlightPackage;
import airport.Passenger;

public class FixedPriceFlight extends Flight {
	private double price;

	public FixedPriceFlight(String origin, String destination, Aircraft aircraft, double price) {
		super(origin, destination, aircraft);
		this.price = price;
	}

	@Override
	public boolean bookSeat(Passenger passenger) {
		boolean booked = false;
		System.out.printf("%s -> %s flight\n", getOrigin(), getDestination());
		Aircraft aircraft = getAircraft();
		if (!aircraft.isFull()) {
			aircraft.bookSeat();
			System.out.printf("Booking seat for %s\n", passenger.getName());
			booked = true;
		} else {
			System.out.println("The aircraft is full");
		}
		return booked;
	}
	
	@Override
	public FlightPackage getPackage() {
		return () -> price;
	}
	
	public double getPrice() {
		return price;
	}
}
