package airport.flight;

import java.util.ArrayList;
import java.util.List;

import airport.order.FlightReservation;

public class CommercialFlightReservation extends FlightReservation {
	private final FlightClass flightClass;
	private final List<FlightExtra> extras;
	
	public CommercialFlightReservation(CommercialFlight flight, FlightClass flightClass) {
		super(flight);
		
		this.flightClass = flightClass;
		this.extras = new ArrayList<>();
	}
	
	@Override
	public double getPrice() {
		// Should check that flightClass is really a flight class and if there are available seats
		// ...or maybe do these checks at a up the hierarchy?
		double classPrice = flightClass.getPrice();
		return classPrice + extras.stream().mapToDouble(FlightExtra::getPrice).sum();
	}
	
	public void addExtra(FlightExtra extra) {
		extras.add(extra);
	}
}
