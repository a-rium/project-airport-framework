package airport.flight.commercial;

import airport.Aircraft;
import airport.flight.CommercialFlight;
import airport.flight.FlightClass;

public class ClasslessFlight extends CommercialFlight {
	public ClasslessFlight(String origin, String destination, Aircraft aircraft, String planName, double price) {
		super(origin, destination, aircraft);
		
		addClass(new FlightClass(planName, price));
	}
	
	public ClasslessFlight(String origin, String destination, Aircraft aircraft, double price) {
		this(origin, destination, aircraft, "Base", price);
	}
	
	public double getPrice() {
		return getClasses().next().getPrice();
	}
}
