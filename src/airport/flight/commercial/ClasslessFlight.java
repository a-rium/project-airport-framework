package airport.flight.commercial;

import airport.Aircraft;
import airport.flight.CommercialFlight;
import airport.flight.FlightClass;

public class ClasslessFlight extends CommercialFlight {
	public ClasslessFlight(CommercialFlightData flightData, Aircraft aircraft, String planName, double price) {
		super(flightData, aircraft);
		
		super.addClass(new FlightClass(planName, price));
	}
	
	public ClasslessFlight(CommercialFlightData flightData, Aircraft aircraft, double price) {
		this(flightData, aircraft, "Base", price);
	}
	
	public double getPrice() {
		return getClasses().next().getPrice();
	}
	
	@Override
	public void addClass(FlightClass flightClass) {
		throw new UnsupportedOperationException("ClasslessFlight can only have one class");
	}
}
