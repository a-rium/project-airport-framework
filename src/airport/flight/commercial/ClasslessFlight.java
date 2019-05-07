package airport.flight.commercial;

import java.time.ZonedDateTime;

import airport.Aircraft;
import airport.flight.CommercialFlight;
import airport.flight.FlightClass;
import airport.FlightData;

public class ClasslessFlight extends CommercialFlight {
	public ClasslessFlight(FlightData data, Aircraft aircraft, String planName, double price) {
		super(data, aircraft);
		
		addClass(new FlightClass(planName, price));
	}
	
	public ClasslessFlight(FlightData data, Aircraft aircraft, double price) {
		this(data, aircraft, "Base", price);
	}
	
	public double getPrice() {
		return getClasses().next().getPrice();
	}
}
