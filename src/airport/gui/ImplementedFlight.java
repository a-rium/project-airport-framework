package airport.gui;

import java.time.ZonedDateTime;

import airport.FlightData;
import airport.flight.commercial.ClasslessFlight;

public class ImplementedFlight extends ClasslessFlight {
	public ImplementedFlight(FlightData data, double price) {
		super(data, new DummyAircraft(0), price);
	}
	
	@Override
	public String toString() {
		return getOrigin() + " -> " + getDestination() + " : " + getPrice();
	}
}
