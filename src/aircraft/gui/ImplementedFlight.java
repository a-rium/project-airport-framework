package aircraft.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import airport.FlightPackage;
import airport.flight.FixedPriceFlight;

public class ImplementedFlight extends FixedPriceFlight {
	private List<NamedExtraPackage> extras;
	
	public ImplementedFlight(String origin, String destination, double price) {
		super(origin, destination, new DummyAircraft(0), price);
		this.extras = new ArrayList<>();
	}
	
	public List<NamedExtraPackage> getExtras() {
		return extras;
	}
	
	public void addExtra(String extraName, UnaryOperator<FlightPackage> extra) {
		extras.add(new NamedExtraPackage(extraName, extra));
	}
	
	@Override
	public String toString() {
		return getOrigin() + " -> " + getDestination() + " : " + getPrice();
	}
}
