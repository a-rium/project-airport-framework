package airport.gui;

import airport.flight.commercial.ClasslessFlight;

public class ImplementedFlight extends ClasslessFlight {
	public ImplementedFlight(String origin, String destination, double price) {
		super(origin, destination, new DummyAircraft(0), price);
	}
	
	@Override
	public String toString() {
		return getOrigin() + " -> " + getDestination() + " : " + getPrice();
	}
}
