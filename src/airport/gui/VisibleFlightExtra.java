package airport.gui;

import airport.flight.FlightExtra;

public class VisibleFlightExtra extends FlightExtra {
	public VisibleFlightExtra(String name, double price) {
		super(name, price);
	}

	@Override
	public String toString() {
		return getName();
	}
}
