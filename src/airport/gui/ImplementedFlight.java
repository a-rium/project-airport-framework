package airport.gui;

import airport.flight.commercial.ClasslessFlight;
import airport.flight.commercial.CommercialFlightData;

public class ImplementedFlight extends ClasslessFlight {
	public ImplementedFlight(CommercialFlightData flightData, double price) {
		super(flightData, new DummyAircraft(0), price);
	}
	
	@Override
	public String toString() {
		return getOrigin() + " -> " + getDestination() + " : " + getPrice();
	}
}
