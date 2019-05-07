package airport.flight;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import airport.Aircraft;
import airport.Flight;
import airport.FlightData;

public class CommercialFlight extends Flight {
	private List<FlightClass> classes;
	private List<FlightExtra> extras;

	public CommercialFlight(FlightData data, Aircraft aircraft) {
		super(data, aircraft);
		this.classes = new ArrayList<>();
		this.extras = new ArrayList<>();
	}

	/*
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
	*/
	
	public void addClass(FlightClass flightClass) {
		classes.add(flightClass);
	}
	
	public Iterator<FlightClass> getClasses() {
		return classes.iterator();
	}
	
	public void addExtra(FlightExtra extra) {
		extras.add(extra);
	}
	
	public Iterator<FlightExtra> getExtras() {
		return extras.iterator();
	}
}
